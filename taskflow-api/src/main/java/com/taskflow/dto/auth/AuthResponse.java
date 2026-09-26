package com.taskflow.dto.auth;

/**
 * AuthResponse — la respuesta de POST /auth/login: SOLO el token JWT. El cliente lo guarda y lo manda
 * en el header 'Authorization: Bearer <token>' en cada request siguiente.
 */
public record AuthResponse(String token) {
}
