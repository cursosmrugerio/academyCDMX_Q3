package com.taskflow.unit;

import com.taskflow.exception.TaskValidationException;
import com.taskflow.model.Priority;
import com.taskflow.model.Task;
import com.taskflow.model.TaskStatus;
import com.taskflow.repository.TaskRepository;
import com.taskflow.service.ReportService;
import com.taskflow.service.TaskOrders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * ReportServiceTest — UNIT PURO con Mockito (S3D1, integrador paso 3: "cobertura guiada por el reporte").
 *
 * ReportService llevaba 2 semanas sin test DIRECTO en la API (los streams de S1D4). El reporte JaCoCo lo
 * delata en rojo; se cubre DONDE ES BARATO: un unit con @Mock TaskRepository. El Mockito de la mañana
 * paga aquí — porcentajeCompletadas esconde la trampa long/long de S1D1 (* 100.0 ANTES de dividir).
 *
 * Los DATOS (Task) se construyen reales; solo el repositorio (colaborador) se mockea.
 */
@ExtendWith(MockitoExtension.class)
class ReportServiceTest {

    @Mock
    private TaskRepository repo;

    @InjectMocks
    private ReportService service;

    // ---- % completadas: la trampa long/long ----

    @Test
    void porcentajeCompletadas_unaDeCuatro_devuelve25() {
        when(repo.count()).thenReturn(4L);
        when(repo.countByStatus(TaskStatus.DONE)).thenReturn(1L);

        // Si fuese división entera (1/4) daría 0.0; el * 100.0 ANTES de dividir salva el cálculo.
        assertEquals(25.0, service.porcentajeCompletadas());
    }

    @Test
    void porcentajeCompletadas_sinTareas_devuelveCeroSinDividirPorCero() {
        when(repo.count()).thenReturn(0L);
        // countByStatus NO se stubbea: con total 0 el método regresa antes (evita 0/0 = NaN). Stubearlo
        // dispararía UnnecessaryStubbingException — el strict-stubs vigila que cada stub tenga propósito.

        assertEquals(0.0, service.porcentajeCompletadas());
    }

    // ---- delegación en derived queries ----

    @Test
    void buscarPorTitulo_delegaEnLaDerivedQuery() {
        List<Task> esperado = List.of(tarea("Documentar la API", TaskStatus.TODO, Priority.MED, 1L));
        when(repo.findByTitleContainingIgnoreCase("api")).thenReturn(esperado);

        assertThat(service.buscarPorTitulo("api")).isEqualTo(esperado);
    }

    @Test
    void pendientes_filtraEnBdYOrdenaEnStream() {
        Task a = tarea("Alta", TaskStatus.TODO, Priority.HIGH, 1L);
        Task b = tarea("Baja", TaskStatus.IN_PROGRESS, Priority.LOW, 1L);
        when(repo.findByStatusNot(TaskStatus.DONE)).thenReturn(List.of(b, a));

        // POR_URGENCIA (reuso de la Strategy de S1): a igualdad de vencidas, HIGH antes que LOW.
        List<Task> orden = service.pendientes(TaskOrders.POR_URGENCIA);

        assertThat(orden).containsExactly(a, b);
    }

    @Test
    void pendientesPorFecha_delegaEnPendientesConPorFecha() {
        when(repo.findByStatusNot(TaskStatus.DONE)).thenReturn(List.of());
        assertThat(service.pendientesPorFecha()).isEmpty();
    }

    // ---- agrupaciones en streams ----

    @Test
    void tareasPorEstado_agrupaPorStatus() {
        when(repo.findAll()).thenReturn(List.of(
                tarea("Uno TODO", TaskStatus.TODO, Priority.MED, 1L),
                tarea("Dos TODO", TaskStatus.TODO, Priority.LOW, 1L),
                tarea("Tres DONE", TaskStatus.DONE, Priority.HIGH, 1L)));

        Map<TaskStatus, List<Task>> porEstado = service.tareasPorEstado();

        assertThat(porEstado.get(TaskStatus.TODO)).hasSize(2);
        assertThat(porEstado.get(TaskStatus.DONE)).hasSize(1);
    }

    @Test
    void tareasPorAsignado_descartaSinResponsableYAgrupa() {
        when(repo.findAll()).thenReturn(List.of(
                tarea("de 10", TaskStatus.TODO, Priority.MED, 10L),
                tarea("de 10 otra", TaskStatus.DONE, Priority.LOW, 10L),
                tarea("sin nadie", TaskStatus.TODO, Priority.HIGH, null)));

        Map<Long, List<Task>> porAsignado = service.tareasPorAsignado();

        assertThat(porAsignado).containsOnlyKeys(10L);
        assertThat(porAsignado.get(10L)).hasSize(2);
    }

    @Test
    void sinAsignar_cuentaSoloLasSinResponsable() {
        when(repo.findAll()).thenReturn(List.of(
                tarea("con", TaskStatus.TODO, Priority.MED, 10L),
                tarea("sin", TaskStatus.TODO, Priority.LOW, null)));

        assertThat(service.sinAsignar()).isEqualTo(1);
    }

    @Test
    void tareasPorPrioridad_yTitulosCsv_stretchCubiertos() {
        when(repo.findAll()).thenReturn(List.of(
                tarea("Uno", TaskStatus.TODO, Priority.HIGH, 1L),
                tarea("Dos", TaskStatus.TODO, Priority.HIGH, 1L)));

        assertThat(service.tareasPorPrioridad().get(Priority.HIGH)).hasSize(2);
        assertThat(service.titulosCsv()).isEqualTo("Uno, Dos");
    }

    /** Dato REAL (constructor de rehidratación). */
    private Task tarea(String title, TaskStatus status, Priority priority, Long assigneeId) {
        try {
            return new Task(null, title, "desc", status, priority, 1L, assigneeId, null);
        } catch (TaskValidationException e) {
            throw new IllegalStateException("dato de prueba inválido", e);
        }
    }
}
