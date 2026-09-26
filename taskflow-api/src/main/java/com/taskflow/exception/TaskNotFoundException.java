package com.taskflow.exception;

/**
 * TaskNotFoundException — se lanza cuando se busca una tarea por id y NO existe.
 *
 * A diferencia de TaskValidationException (checked, para reglas de negocio del input),
 * esta es UNCHECKED (extiende RuntimeException): un id inexistente suele ser un caso de
 * "no encontrado" que se maneja en un punto concreto (el advice REST), no una condición que TODO
 * método que la toque deba declarar. Se lanza con el patrón Optional/orElseThrow:
 *
 *     Task t = repo.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
 *
 * Guarda el id que no se encontró (útil para el mensaje y para el log). El GlobalExceptionHandler
 * la mapea a un 404.
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
