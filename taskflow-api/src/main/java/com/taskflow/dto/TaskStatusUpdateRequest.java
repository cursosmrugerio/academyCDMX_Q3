package com.taskflow.dto;

import com.taskflow.model.TaskStatus;
import jakarta.validation.constraints.NotNull;

/**
 * TaskStatusUpdateRequest — el cuerpo del PATCH /tasks/{id}/status (MP-9). Un DTO por OPERACIÓN: el
 * único campo que este endpoint puede tocar es el estado. Es la respuesta al riesgo del PUT (error
 * intencional #3): en vez de reemplazar TODA la tarea para cambiar un campo, un DTO chico y preciso.
 *
 * @NotNull sobre el enum: si el JSON trae {"status": null} o no trae la clave, la validación da 400.
 * OJO al orden parseo -> validación: {"status":"FINISHED"} (valor que no matchea el enum) NUNCA llega
 * a @NotNull; truena antes, en la deserialización de Jackson (HttpMessageNotReadableException -> 400).
 */
public record TaskStatusUpdateRequest(

        @NotNull(message = "El estado es obligatorio.")
        TaskStatus status
) {
}
