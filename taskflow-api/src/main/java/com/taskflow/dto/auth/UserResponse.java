package com.taskflow.dto.auth;

import com.taskflow.model.Role;

/**
 * UserResponse — la salida de /auth/register (y de /auth/me). Es el "espejo seguro" de User:
 * los datos públicos SIN el passwordHash. Disciplina: NUNCA se expone la entidad User en una
 * respuesta, o el hash se filtraría al JSON.
 */
public record UserResponse(
        Long id,
        String username,
        String email,
        Role role
) {
}
