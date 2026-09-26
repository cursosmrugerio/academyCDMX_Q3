package com.taskflow.exception;

/**
 * ProjectNotFoundException — se lanza cuando se busca un proyecto por id y NO existe. Nace HOY
 * (S2D3, integrador paso 4). El GlobalExceptionHandler la mapea a 404, en el MISMO handler que
 * TaskNotFoundException (un solo @ExceptionHandler con dos tipos).
 *
 * Gemela de TaskNotFoundException (S1D4): UNCHECKED (extiende RuntimeException), guarda el id que no
 * se encontró y sube sola hasta el advice. La usan ProjectService (GET/PUT/DELETE de un proyecto
 * inexistente) y el cableo Task↔Project (POST /projects/{id}/tasks contra un proyecto que no existe).
 */
public class ProjectNotFoundException extends RuntimeException {

    private final Long id;

    public ProjectNotFoundException(Long id) {
        super("No existe proyecto con id " + id + ".");
        this.id = id;
    }

    /** El id que se buscó y no existía. */
    public Long getId() {
        return id;
    }
}
