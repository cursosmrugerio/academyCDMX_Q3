package com.taskflow.exception;

/**
 * UsernameAlreadyExistsException — se lanza al registrar (POST /auth/register) un username que YA
 * existe. Nace HOY (S2D5, MP-5). El GlobalExceptionHandler la mapea a 409 Conflict: el request está
 * bien formado, pero choca con el estado actual del recurso (username único).
 *
 * UNCHECKED (extiende RuntimeException), como las *NotFoundException de S1/S2: sube sola hasta el
 * advice sin ensuciar las firmas.
 */
public class UsernameAlreadyExistsException extends RuntimeException {

    public UsernameAlreadyExistsException(String username) {
        super("Ya existe un usuario con username '" + username + "'.");
    }
}
