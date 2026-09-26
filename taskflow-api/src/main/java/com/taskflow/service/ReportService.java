package com.taskflow.service;

import com.taskflow.model.Priority;
import com.taskflow.model.Task;
import com.taskflow.model.TaskStatus;
import com.taskflow.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ReportService — los reportes, cada uno calculado donde conviene, con JUICIO.
 *
 * La idea NO es "meter derived queries en todo": es DECIDIR, método por método, dónde manda la
 * BD y dónde mandan los streams. Los métodos de consulta llevan un comentario que justifica la
 * decisión. Tres categorías:
 *   - DERIVED: el filtro/conteo lo hace la BD y viajan menos filas (buscarPorTitulo, porcentaje...).
 *   - MIXTO: la BD filtra, el stream ordena porque el orden es regla de DOMINIO, no del dialecto.
 *   - STREAMS: agrupaciones Map&lt;K, List&lt;Task&gt;&gt; que SQL GROUP BY no devuelve (da conteos);
 *     a esta escala la claridad gana. Nota honesta: con millones de filas se repiensa.
 *
 * repo es el JpaRepository (proxy de Spring Data), pero el constructor recibe la INTERFAZ
 * TaskRepository por inyección: no depende de qué implementación hay detrás. Esa es la paga de
 * programar contra el contrato.
 */
@Service
public class ReportService {

    private final TaskRepository repo;

    public ReportService(TaskRepository repo) {
        this.repo = repo;
    }

    // ---- Predicados nombrados (se leen como reglas de negocio y se reutilizan en los streams) ----

    /** Una tarea está pendiente mientras NO esté DONE. '!=' entre enums es seguro. */
    public static final Predicate<Task> ES_PENDIENTE = t -> t.getStatus() != TaskStatus.DONE;

    /** Está sin asignar si no tiene responsable. */
    public static final Predicate<Task> SIN_ASIGNAR = t -> t.getAssigneeId() == null;

    // ==================== Reportes ====================

    /**
     * Tareas por estado: agrupa por estado.
     * streams: SQL GROUP BY devuelve CONTEOS, no Map&lt;Enum, List&lt;Task&gt;&gt;; a esta escala la claridad gana.
     */
    public Map<TaskStatus, List<Task>> tareasPorEstado() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(Task::getStatus));
    }

    /**
     * Pendientes ordenadas con la ESTRATEGIA que se le pase.
     * mixto: el filtro "no DONE" va a la BD (findByStatusNot); el ORDEN es intercambiable y de dominio, en stream.
     */
    public List<Task> pendientes(Comparator<Task> orden) {
        return repo.findByStatusNot(TaskStatus.DONE).stream()
                .sorted(orden)
                .collect(Collectors.toList());
    }

    /**
     * Pendientes ordenadas por fecha. Delega en la sobrecarga con POR_FECHA.
     * mixto: el orden de los null (nullsLast) es regla de DOMINIO, no del dialecto — el comparator se queda en Java.
     */
    public List<Task> pendientesPorFecha() {
        return pendientes(TaskOrders.POR_FECHA);
    }

    /**
     * Buscar por título: las tareas cuyo título CONTIENE q, sin distinguir mayúsculas.
     * derived: el LIKE lo hace la BD (findByTitleContainingIgnoreCase); viajan menos filas que traer todo y filtrar en memoria.
     */
    public List<Task> buscarPorTitulo(String q) {
        return repo.findByTitleContainingIgnoreCase(q);
    }

    /**
     * % completadas: DONE respecto al total.
     * derived: contar en la BD (countByStatus/count), no traer todo para contarlo; ojo con la trampa long/long (* 100.0).
     */
    public double porcentajeCompletadas() {
        long total = repo.count();
        if (total == 0) {
            return 0.0;                                  // evita 0/0 = NaN
        }
        long completadas = repo.countByStatus(TaskStatus.DONE);
        return completadas * 100.0 / total;             // * 100.0 ANTES de dividir (si no, división entera -> 0)
    }

    /**
     * Tareas por asignado: agrupa por assigneeId (primero descarta las sin responsable: groupingBy
     * lanza NPE si el clasificador da null).
     * streams: es otra agrupación Map&lt;K, List&lt;Task&gt;&gt; que GROUP BY no devuelve; claridad a esta escala.
     */
    public Map<Long, List<Task>> tareasPorAsignado() {
        return repo.findAll().stream()
                .filter(SIN_ASIGNAR.negate())
                .collect(Collectors.groupingBy(Task::getAssigneeId));
    }

    /** Cuántas tareas están sin asignar (complemento del reporte anterior). */
    public long sinAsignar() {
        return repo.findAll().stream()
                .filter(SIN_ASIGNAR)
                .count();
    }

    // ==================== Reportes extra ====================

    /** Tareas por prioridad: mismo patrón de agrupación en stream. */
    public Map<Priority, List<Task>> tareasPorPrioridad() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(Task::getPriority));
    }

    /** Exportar títulos a una sola línea CSV con Collectors.joining(", "). */
    public String titulosCsv() {
        return repo.findAll().stream()
                .map(Task::getTitle)
                .collect(Collectors.joining(", "));
    }
}
