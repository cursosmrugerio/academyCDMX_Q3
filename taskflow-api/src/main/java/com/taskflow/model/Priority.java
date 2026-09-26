package com.taskflow.model;

/**
 * Priority — prioridad de una tarea. Declarada en orden LOW, MED, HIGH.
 *
 * Ese orden de DECLARACIÓN es el orden NATURAL del enum (compareTo lo usa), y de él
 * depende el sort del Día 3: por eso ordenar "de menor a mayor prioridad" da LOW -> HIGH,
 * y "prioridad descendente" (HIGH primero) se logra con Comparator.reverseOrder().
 *
 * Cada constante lleva su 'etiqueta' legible en español.
 */
public enum Priority {
    LOW("Baja"),
    MED("Media"),
    HIGH("Alta");

    private final String etiqueta;

    Priority(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}
