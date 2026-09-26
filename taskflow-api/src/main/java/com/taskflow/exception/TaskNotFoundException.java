package com.taskflow.exception;

/**
 * TaskNotFoundException — se lanza cuando se busca una tarea por id y NO existe.
 *
 * A diferencia de TaskValidationException (checked, para reglas de negocio del input),
 * esta es UNCHECKED (extiende RuntimeException): un id inexistente suele ser un caso de
 * "no encontrado" que se maneja en un punto concreto (el menú), no una condición que TODO
 * método que la toque deba declarar. Nace HOY (S1D4) con la cirugía de Optional/orElseThrow:
 *
 *     Task t = repo.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
 *
 * Guarda el id que no se encontró (útil para el mensaje y para el log). Forma parte del
 * estado final de S1 y viaja a S2 tal cual: allá el advice REST la mapeará a un 404.
 *
 * Nombre y paquete canónicos de S1 (apéndice del CAPSTONE-SPEC):
 * com.taskflow.exception.TaskNotFoundException.
 */
public class TaskNotFoundException extends RuntimeException {

    private final Long id;

    public TaskNotFoundException(Long id) {
        super("No existe tarea con id " + id + ".");
        this.id = id;
    }

    /** El id que se buscó y no existía. */
    public Long getId() {
        return id;
    }
}
