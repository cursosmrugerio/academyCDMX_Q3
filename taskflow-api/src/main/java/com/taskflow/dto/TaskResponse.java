package com.taskflow.dto;

import com.taskflow.model.Priority;
import com.taskflow.model.TaskStatus;

import java.time.LocalDate;

/**
 * TaskResponse — el CONTRATO de SALIDA de una tarea (lo que la API devuelve). Es un record: Jackson
 * lo serializa a JSON por sus componentes.
 *
 * "¿Si trae los mismos 8 campos que la entidad, para qué el DTO?" — son casi iguales; el valor
 * es el DESACOPLE. La entidad Task lleva anotaciones JPA (@Entity/@Id...) que NO tienen por qué
 * asomar en el JSON, y hay entidades con campos que JAMÁS deben salir (el passwordHash de User). El
 * contrato de salida se mantiene estable aunque la entidad cambie por dentro.
 */
public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskStatus status,
        Priority priority,
        Long projectId,
        Long assigneeId,
        LocalDate dueDate
) {
}
