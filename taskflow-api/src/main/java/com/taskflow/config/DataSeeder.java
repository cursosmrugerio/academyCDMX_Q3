package com.taskflow.config;

import com.taskflow.exception.TaskValidationException;
import com.taskflow.model.Priority;
import com.taskflow.model.Project;
import com.taskflow.model.Role;
import com.taskflow.model.Task;
import com.taskflow.model.TaskStatus;
import com.taskflow.model.User;
import com.taskflow.repository.ProjectRepository;
import com.taskflow.repository.TaskRepository;
import com.taskflow.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * DataSeeder — la semilla del proyecto. Escribe en la BD (H2 archivo en runtime) a través de los
 * repositorios JPA, condicionada a count()==0 (con ddl-auto=update los datos SOBREVIVEN al reinicio;
 * sembrar en cada arranque duplicaría todo).
 *
 * CAMBIO DE HOY (S2D5, MP-3): los usuarios ganan passwordHash. Decisión canónica (punto de dolor 3):
 * sembrar con el PasswordEncoder INYECTADO (no data.sql con hashes a mano) — hashes siempre válidos y
 * el código DOCUMENTA los passwords de prueba. El mismo password produce hashes DISTINTOS cada vez
 * (salt) -> se verifica con matches(), jamás comparando strings.
 *
 * Usuarios semilla CANÓNICOS del día (los usan tests, demo y Postman):
 *   ana   / ana123   / USER  (id 1) — owner del proyecto 1
 *   luis  / luis123  / USER  (id 2) — owner del proyecto 2 (App Movil), NO del 1 -> por eso es el
 *                                    protagonista del 403: borrar el proyecto 1, que es de ana
 *   admin / admin123 / ADMIN (id 3) — puede borrar cualquier proyecto
 * Son los MISMOS ana/luis de la semilla D4 (ahora con passwordHash y ana pasa de ADMIN a USER, la
 * forma canónica) MÁS admin NUEVO — no se duplican usuarios. El proyecto 1 tiene ownerId = ana (id 1),
 * la base de la regla "solo owner o ADMIN borra el proyecto".
 *
 * IMPORTANTE al cambiar la entidad User (nueva columna password_hash): con ddl-auto=update, borra
 * data/*.mv.db y deja que este seeder resiembre — si no, la columna vieja no cuadra.
 *
 * IDs por orden de inserción en BD fresca: users ana(1)/luis(2)/admin(3); projects 1..3; tasks 1..9.
 * El ORDEN users -> projects -> tasks lo OBLIGA la FK task.project_id.
 */
@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final PasswordEncoder passwordEncoder;   // D5: para hashear los passwords semilla

    public DataSeeder(UserRepository userRepository, ProjectRepository projectRepository,
                      TaskRepository taskRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (taskRepository.count() > 0) {
            return;   // ya hay datos (arranque posterior con ddl-auto=update): no re-sembrar
        }
        try {
            sembrarUsuarios();
            sembrarProyectos();
            sembrarTareas();
        } catch (TaskValidationException e) {
            // La semilla es válida por construcción: si falla, es un error de programación, no de negocio.
            throw new IllegalStateException("La semilla inicial no pudo construirse: " + e.getMessage(), e);
        }
    }

    /**
     * 3 usuarios CANÓNICOS con passwordHash (BCrypt vía el encoder inyectado): ana (id 1, USER, owner
     * del proyecto 1), luis (id 2, USER), admin (id 3, ADMIN). En H2 se ve la columna password_hash
     * con prefijo $2a$.
     */
    private void sembrarUsuarios() {
        userRepository.save(new User(null, "ana", passwordEncoder.encode("ana123"),
                "ana@taskflow.dev", Role.USER));      // -> id 1, owner del proyecto 1
        userRepository.save(new User(null, "luis", passwordEncoder.encode("luis123"),
                "luis@taskflow.dev", Role.USER));     // -> id 2, protagonista del 403
        userRepository.save(new User(null, "admin", passwordEncoder.encode("admin123"),
                "admin@taskflow.dev", Role.ADMIN));   // -> id 3, borra cualquier proyecto
    }

    /** 3 proyectos (ids 1..3). El proyecto 1 pertenece a ana (id 1); el 3 se queda SIN tareas. */
    private void sembrarProyectos() {
        projectRepository.save(new Project(null, "Plataforma TaskFlow",
                "El backend REST del capstone", 1L, LocalDate.now().minusDays(30)));    // -> id 1, owner ana
        projectRepository.save(new Project(null, "App Móvil",
                "Cliente móvil que consume la API", 2L, LocalDate.now().minusDays(20))); // -> id 2, owner luis
        projectRepository.save(new Project(null, "Migración Legacy",
                "Aún sin tareas cargadas", 1L, LocalDate.now().minusDays(5)));           // -> id 3, sin tareas
    }

    /**
     * 9 tareas por el CONSTRUCTOR de rehidratación (id = null -> la BD lo asigna). El orden de
     * inserción fija los ids 1..9. Reparto: proyecto 1 = tareas 1..5; proyecto 2 = tareas 6..9;
     * proyecto 3 = 0. Fechas RELATIVAS a hoy. La tarea 7 es la única VENCIDA; la 6 es la única sin
     * responsable elegible para el 422; DONE = tareas 2 y 8.
     */
    private void sembrarTareas() throws TaskValidationException {
        // --- Proyecto 1: Plataforma TaskFlow (tareas 1..5) ---
        taskRepository.save(new Task(null, "Diseñar esquema de BD", "Tablas projects/tasks/users",
                TaskStatus.TODO, Priority.HIGH, 1L, 1L, LocalDate.now().plusDays(5)));           // id 1
        taskRepository.save(new Task(null, "Configurar Spring Boot", "Initializr + starter-web",
                TaskStatus.DONE, Priority.MED, 1L, 1L, LocalDate.now().minusDays(2)));           // id 2 (DONE)
        taskRepository.save(new Task(null, "Endpoint de login", "POST /auth/login con JWT",
                TaskStatus.IN_PROGRESS, Priority.HIGH, 1L, 2L, LocalDate.now().plusDays(3)));    // id 3
        taskRepository.save(new Task(null, "Escribir tests MockMvc", "Capa web con @SpringBootTest",
                TaskStatus.TODO, Priority.MED, 1L, null, LocalDate.now().plusDays(7)));          // id 4 (SIN assignee)
        taskRepository.save(new Task(null, "Optimizar consultas de la API", "Índices y paginación",
                TaskStatus.TODO, Priority.LOW, 1L, 1L, null));                                   // id 5

        // --- Proyecto 2: App Móvil (tareas 6..9) ---
        taskRepository.save(new Task(null, "Publicar en la tienda", "Alta en App Store / Play",
                TaskStatus.TODO, Priority.HIGH, 2L, null, LocalDate.now().plusDays(10)));        // id 6 (SIN assignee -> 422)
        taskRepository.save(new Task(null, "Corregir bug de fechas", "Zona horaria en el cliente",
                TaskStatus.IN_PROGRESS, Priority.LOW, 2L, 2L, LocalDate.now().minusDays(1)));    // id 7 (VENCIDA)
        taskRepository.save(new Task(null, "Integrar pasarela de pago", "Checkout con Stripe",
                TaskStatus.DONE, Priority.HIGH, 2L, 1L, LocalDate.now().minusDays(5)));          // id 8 (DONE)
        taskRepository.save(new Task(null, "Documentar la API con Swagger", "OpenAPI 3",
                TaskStatus.IN_PROGRESS, Priority.MED, 2L, 2L, null));                            // id 9
    }
}
