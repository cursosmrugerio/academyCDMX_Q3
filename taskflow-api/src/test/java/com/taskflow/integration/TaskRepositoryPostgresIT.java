package com.taskflow.integration;

import com.taskflow.exception.TaskValidationException;
import com.taskflow.model.Priority;
import com.taskflow.model.Project;
import com.taskflow.model.Task;
import com.taskflow.model.TaskStatus;
import com.taskflow.repository.TaskRepository;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TaskRepositoryPostgresIT — el mismo test de repositorio, contra un Postgres REAL.
 *
 * Es el MISMO @DataJpaTest de repositorio de S3D1 (TaskRepositoryTest), pero corriendo contra un
 * Postgres 16 REAL y EFÍMERO en lugar de H2. Cierra el círculo que S3D1 dejó abierto: "Testcontainers
 * llega mañana, cuando tengamos Docker" — y hoy ya tenemos Docker.
 *
 * Mensaje del anexo: H2 nos sirvió para APRENDER y sigue siendo válida en slices rápidos (la pirámide);
 * en la industria, la integración se prueba contra la MISMA base que producción. Costo honesto:
 * Testcontainers arranca en SEGUNDOS (levanta un contenedor), H2 en MILISEGUNDOS — por eso conviven.
 *
 * Cómo correrlo:
 *   1) Docker levantado (el daemon debe responder).
 *   2) En dos terminales:
 *        (A)  mvn test -Ddocker.tests=true
 *        (B)  watch docker ps -a     # ver el contenedor postgres:16 NACER y MORIR solo
 *   Las dependencias de Testcontainers YA están en el pom (junit-jupiter + postgresql +
 *   spring-boot-testcontainers, scope test).
 *
 * Cómo funciona la magia:
 *   - @Testcontainers + @Container: JUnit arranca el contenedor ANTES de los tests y lo apaga al final.
 *   - @ServiceConnection (Boot 3.1+): Spring lee host/puerto/credenciales del contenedor y los cablea
 *     al datasource SOLO. Cero URLs a mano.
 *   - @AutoConfigureTestDatabase(replace = NONE): sin esto, @DataJpaTest cambiaría el datasource por una
 *     H2 embebida y el contenedor no serviría de nada. Con NONE, respeta el Postgres de Testcontainers.
 *
 * Por qué NO corre por defecto: exige Docker, y 'mvn test'/'mvn verify' tienen que seguir VERDES
 * en una máquina sin él. Dos candados, a propósito:
 *   · el perfil `docker-it` del pom es el único que hace que surefire recoja *IT.java, y
 *   · @EnabledIfSystemProperty deja la clase saltada también si la lanzas desde Eclipse sin la bandera.
 * El perfil además FIJA api.version=1.41: sin eso, el cliente docker-java que arrastra Boot 3.5.x
 * negocia por debajo de la API mínima de Docker moderno y falla con «Could not find a valid Docker
 * environment» — un mensaje que no menciona versiones y manda a buscar en el sitio equivocado.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
@EnabledIfSystemProperty(named = "docker.tests", matches = "true")
class TaskRepositoryPostgresIT {

    // La MISMA imagen que producción y que el servicio 'db' del compose: postgres:16.
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16");

    @Autowired
    private TestEntityManager em;

    @Autowired
    private TaskRepository taskRepository;

    private Long nuevoProyecto(String name) {
        Project p = em.persistFlushFind(new Project(null, name, "desc", 1L, LocalDate.now().minusDays(1)));
        return p.getId();
    }

    /**
     * save asigna id — pero ahora el id lo genera la SECUENCIA de Postgres, no la de H2. El código de la
     * app ni se enteró: la @Entity y el JpaRepository son idénticos. Eso compró JPA (dialecto por debajo).
     */
    @Test
    void save_asignaId_generadoPorPostgres() throws TaskValidationException {
        Long pid = nuevoProyecto("Proyecto Postgres");

        Task guardada = taskRepository.save(
                new Task(null, "Primera tarea", "desc", TaskStatus.TODO, Priority.MED, pid, 1L, null));

        assertThat(guardada.getId()).isNotNull();
    }

    /** La derived query findByStatus corre igual contra el SQL de Postgres. */
    @Test
    void findByStatus_filtraCorrecto_enPostgres() throws TaskValidationException {
        Long pid = nuevoProyecto("Proyecto B");
        em.persistFlushFind(new Task(null, "TODO uno", "desc", TaskStatus.TODO, Priority.LOW, pid, 1L, null));
        em.persistFlushFind(new Task(null, "TODO dos", "desc", TaskStatus.TODO, Priority.MED, pid, 1L, null));
        em.persistFlushFind(new Task(null, "Hecha", "desc", TaskStatus.DONE, Priority.HIGH, pid, 1L, null));

        List<Task> todo = taskRepository.findByStatus(TaskStatus.TODO);

        assertThat(todo).hasSize(2);
        assertThat(todo).allMatch(t -> t.getStatus() == TaskStatus.TODO);
    }

    /**
     * El mapeo @Enumerated(STRING) va y vuelve como TEXTO también en Postgres. flush()+clear() fuerza el
     * viaje REAL a SQL (sin caché de 1er nivel que mienta) — la misma lección de S3D1, otra base.
     */
    @Test
    void mapeoDeStatus_sobreviveFlushYClear_enPostgres() throws TaskValidationException {
        Long pid = nuevoProyecto("Proyecto flush");
        Task persistida = em.persistFlushFind(
                new Task(null, "Mapeo honesto", "desc", TaskStatus.IN_PROGRESS, Priority.HIGH, pid, 1L, null));
        Long id = persistida.getId();

        em.clear();

        Task releida = taskRepository.findById(id).orElseThrow();
        assertThat(releida.getStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
    }
}
