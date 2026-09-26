package com.taskflow.service;

import com.taskflow.model.Task;

import java.util.Comparator;

/**
 * TaskOrders — catálogo de ESTRATEGIAS de ordenamiento de tareas (MP-3, patrón Strategy).
 *
 * Cada constante es una estrategia empaquetada como VALOR (un {@link Comparator}) que se PASA a
 * quien ordena (el contexto: {@code sorted(...)} de los streams). Es el mismo patrón que ya usaron
 * en S1D3/D4 sin nombre: un Comparator es una estrategia, y sort/sorted es el contexto que la
 * recibe sin saber cuál le tocó. Aquí les damos NOMBRE y las juntamos en un solo lugar reutilizable.
 *
 * Se reutiliza tal cual en S2: {@code TaskService.listar()} de la API ordena con POR_URGENCIA.
 *
 * Clase de utilidades: constructor privado (no se instancia — solo se usan sus constantes).
 */
public final class TaskOrders {

    private TaskOrders() {
        // no instanciable: es un catálogo de constantes
    }

    /**
     * POR_FECHA — la estrategia "de siempre" (S1D4): dueDate ascendente, con las tareas SIN fecha
     * (dueDate null) al FINAL. nullsLast evita el NullPointerException al comparar una fecha null.
     */
    public static final Comparator<Task> POR_FECHA =
            Comparator.comparing(Task::getDueDate,
                    Comparator.nullsLast(Comparator.naturalOrder()));

    /** POR_TITULO — orden alfabético por título, sin distinguir mayúsculas/minúsculas. */
    public static final Comparator<Task> POR_TITULO =
            Comparator.comparing(Task::getTitle, String.CASE_INSENSITIVE_ORDER);

    /**
     * POR_URGENCIA — la estrategia NUEVA de MP-3, encadenando comparing/thenComparing de S1D3:
     *   1) las VENCIDAS primero (estaVencida() == true antes que false),
     *   2) a igualdad, prioridad de mayor a menor (HIGH -> MED -> LOW),
     *   3) a igualdad, dueDate ascendente con las sin fecha al final.
     *
     * Detalle: el orden natural del enum Priority es LOW, MED, HIGH (LOW el menor); por eso
     * reverseOrder() deja HIGH primero. Y reverseOrder() sobre el boolean de estaVencida() deja
     * el true (vencida) antes que el false.
     */
    public static final Comparator<Task> POR_URGENCIA =
            Comparator.comparing(Task::estaVencida, Comparator.reverseOrder())
                    .thenComparing(Task::getPriority, Comparator.reverseOrder())
                    .thenComparing(Task::getDueDate,
                            Comparator.nullsLast(Comparator.naturalOrder()));
}
