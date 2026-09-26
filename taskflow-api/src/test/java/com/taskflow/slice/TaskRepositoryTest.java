package com.taskflow.slice;

import com.taskflow.exception.TaskValidationException;
import com.taskflow.model.Priority;
import com.taskflow.model.Project;
import com.taskflow.model.Task;
import com.taskflow.model.TaskStatus;
import com.taskflow.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TaskRepositoryTest — SLICE de JPA (@DataJpaTest). D4 lo estrenó; S3D1 lo PROFUNDIZA (MP-8).
 *
 * @DataJpaTest arranca solo la capa JPA: H2 EN MEMORIA con esquema FRESCO por test (auto-reemplaza el
 * datasource), Hibernate y TestEntityManager. NO carga el DataSeeder ni los @Service: la BD empieza
 * VACÍA y cada test siembra lo suyo. Es transaccional -> rollback por test (aislamiento).
 *
 * Novedades de hoy:
 *   - flush()+clear() para tests de MAPEO: sin ellos, releer devuelve el mismo objeto del caché de 1er
 *     nivel (el mapeo pudo estar roto y el test verde — el falso verde, dolor #11).
 *   - @Sql: escenarios grandes se DECLARAN en un script, no se construyen a mano (MP-8).
 *   - @EnumSource: findByStatus probado para CADA estado con un solo método parametrizado.
 *
 * La FK task.project_id enseña ORDEN: persistir el Project ANTES que sus tareas.
 */
@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private TaskRepository taskRepository;

    // ---- helpers ----

    private Long nuevoProyecto(String name) {
        Project p = em.persistFlushFind(new Project(null, name, "desc", 1L, LocalDate.now().minusDays(1)));
        return p.getId();
    }

    private Task persistirTarea(String title, TaskStatus status, Priority priority,
                                Long projectId, Long assigneeId, LocalDate due) throws TaskValidationException {
        return em.persistFlushFind(
                new Task(null, title, "desc", status, priority, projectId, assigneeId, due));
    }

    // ==================== Tests base (D4, ≥6) ====================

    @Test
    void save_asignaId_yNoEsLaSecuenciaDeInMemory() throws TaskValidationException {
        Long pid = nuevoProyecto("Proyecto A");

        Task guardada = taskRepository.save(
                new Task(null, "Primera tarea", "desc", TaskStatus.TODO, Priority.MED, pid, 1L, null));

        assertThat(guardada.getId()).isNotNull();
    }

    @Test
    void findById_inexistente_optionalVacio() {
        assertThat(taskRepository.findById(9_999L)).isEmpty();
    }

    @Test
    void findByStatus_filtraCorrecto() throws TaskValidationException {
        Long pid = nuevoProyecto("Proyecto B");
        persistirTarea("TODO uno", TaskStatus.TODO, Priority.LOW, pid, 1L, null);
        persistirTarea("TODO dos", TaskStatus.TODO, Priority.MED, pid, 1L, null);
        persistirTarea("Hecha", TaskStatus.DONE, Priority.HIGH, pid, 1L, null);

        List<Task> todo = taskRepository.findByStatus(TaskStatus.TODO);

        assertThat(todo).hasSize(2);
        assertThat(todo).allMatch(t -> t.getStatus() == TaskStatus.TODO);
    }

    @Test
    void findByProjectId_soloLasDelProyecto() throws TaskValidationException {
        Long pidA = nuevoProyecto("Proyecto con dos");
        Long pidB = nuevoProyecto("Proyecto con una");
        persistirTarea("A-1", TaskStatus.TODO, Priority.LOW, pidA, 1L, null);
        persistirTarea("A-2", TaskStatus.IN_PROGRESS, Priority.MED, pidA, 1L, null);
        persistirTarea("B-1", TaskStatus.TODO, Priority.HIGH, pidB, 1L, null);

        List<Task> deA = taskRepository.findByProjectId(pidA);

        assertThat(deA).hasSize(2);
        assertThat(deA).allMatch(t -> t.getProjectId().equals(pidA));
    }

    @Test
    void findByAssigneeIdAndStatus_combinaCriterios() throws TaskValidationException {
        Long pid = nuevoProyecto("Proyecto C");
        persistirTarea("De 5, TODO", TaskStatus.TODO, Priority.MED, pid, 5L, null);
        persistirTarea("De 5, DONE", TaskStatus.DONE, Priority.MED, pid, 5L, null);
        persistirTarea("De 6, TODO", TaskStatus.TODO, Priority.MED, pid, 6L, null);

        List<Task> resultado = taskRepository.findByAssigneeIdAndStatus(5L, TaskStatus.TODO);

        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getTitle()).isEqualTo("De 5, TODO");
    }

    @Test
    void countByStatus_yTituloContaining() throws TaskValidationException {
        Long pid = nuevoProyecto("Proyecto D");
        persistirTarea("Documentar la API", TaskStatus.TODO, Priority.HIGH, pid, 1L, null);
        persistirTarea("api gateway", TaskStatus.TODO, Priority.LOW, pid, 1L, null);
        persistirTarea("Sin coincidencia", TaskStatus.DONE, Priority.MED, pid, 1L, null);

        assertThat(taskRepository.countByStatus(TaskStatus.TODO)).isEqualTo(2);
        assertThat(taskRepository.findByTitleContainingIgnoreCase("api")).hasSize(2);
    }

    // ==================== S3D1: flush/clear, @Sql, @EnumSource ====================

    /**
     * MP-8 (1) — la regla del mapeo: flush()+clear() ANTES de leer. persistFlushFind deja el objeto en el
     * caché de 1er nivel; clear() lo DETACHA, así el findById siguiente hace el viaje REAL a SQL y valida
     * que el @Enumerated(STRING) fue y volvió como texto. (En clase se rompe el mapeo a propósito para
     * ver el falso verde; aquí queda la versión honesta.)
     */
    @Test
    void mapeoDeStatus_sobreviveFlushYClear() throws TaskValidationException {
        Long pid = nuevoProyecto("Proyecto flush");
        Task persistida = em.persistFlushFind(
                new Task(null, "Mapeo honesto", "desc", TaskStatus.IN_PROGRESS, Priority.HIGH, pid, 1L, null));
        Long id = persistida.getId();

        em.clear();   // vacía el caché de 1er nivel: el siguiente find NO puede mentir con memoria vieja

        Task releida = taskRepository.findById(id).orElseThrow();
        assertThat(releida.getStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
    }

    /**
     * MP-8 (2) — escenario DECLARATIVO con @Sql: 2 proyectos + 8 tareas cargadas por script. El filtro
     * combinado assignee=10 AND status=TODO cae exactamente sobre las tareas 1 y 2 del script. Los ids
     * fijos valen SOLO aquí (esquema fresco por test); jamás se asumen en otra clase (dolor #12).
     */
    @Test
    @Sql("/sql/escenario-tareas.sql")
    void findByAssigneeIdAndStatus_sobreEscenarioSql_filtraCombinado() {
        List<Task> resultado = taskRepository.findByAssigneeIdAndStatus(10L, TaskStatus.TODO);

        assertThat(resultado).hasSize(2);
        assertThat(resultado).allMatch(t -> t.getAssigneeId() == 10L && t.getStatus() == TaskStatus.TODO);
    }

    /**
     * Integrador (refactor c) — @EnumSource: findByStatus probado para CADA valor de TaskStatus en un
     * solo método. Cada estado siembra su tarea y verifica que la derived query la trae (y solo esa).
     */
    @ParameterizedTest
    @EnumSource(TaskStatus.class)
    void findByStatus_paraCadaEstado_devuelveSoloEseEstado(TaskStatus status) throws TaskValidationException {
        Long pid = nuevoProyecto("Proyecto " + status);
        persistirTarea("Tarea " + status, status, Priority.MED, pid, 1L, null);

        List<Task> encontradas = taskRepository.findByStatus(status);

        assertThat(encontradas).hasSize(1);
        assertThat(encontradas.get(0).getStatus()).isEqualTo(status);
    }
}
