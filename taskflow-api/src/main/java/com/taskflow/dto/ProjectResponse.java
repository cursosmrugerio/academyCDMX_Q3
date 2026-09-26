package com.taskflow.dto;

import java.time.LocalDate;

/**
 * ProjectResponse — el contrato de salida de un proyecto.
 *
 * 'ownerId' (un Long) es la forma CANÓNICA del capstone; la entidad Project todavía modela 'User
 * owner' como OBJETO (se aplana a Long en D4 con JPA). El ProjectMapper hace el puente: deriva
 * ownerId con owner.id(). Así el JSON ya expone el contrato final aunque el dominio aún no lo sea.
 */
public record ProjectResponse(
        Long id,
        String name,
        String description,
        Long ownerId,
        LocalDate createdAt
) {
}
