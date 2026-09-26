package com.taskflow.dto;

import java.time.LocalDate;

/**
 * ProjectResponse — el contrato de salida de un proyecto.
 *
 * 'ownerId' es un Long, no un User anidado: el JSON referencia al dueño por su id. La entidad
 * Project guarda ese mismo ownerId, así que ProjectMapper lo copia tal cual.
 */
public record ProjectResponse(
        Long id,
        String name,
        String description,
        Long ownerId,
        LocalDate createdAt
) {
}
