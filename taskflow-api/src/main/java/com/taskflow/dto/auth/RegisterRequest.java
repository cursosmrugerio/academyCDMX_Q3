package com.taskflow.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * RegisterRequest — cuerpo de POST /auth/register (T5). El password en CLARO viaja UNA vez y muere
 * aquí: el service lo hashea con BCrypt y jamás se devuelve. Reusa Bean Validation de D3 (@Valid en el
 * controller -> 400 con detalle por campo si falla).
 */
public record RegisterRequest(

        @NotBlank(message = "El username es obligatorio.")
        @Size(min = 3, max = 50, message = "El username debe tener entre 3 y 50 caracteres.")
        String username,

        @NotBlank(message = "El email es obligatorio.")
        @Email(message = "El email no tiene un formato válido.")
        String email,

        @NotBlank(message = "El password es obligatorio.")
        @Size(min = 6, max = 100, message = "El password debe tener al menos 6 caracteres.")
        String password
) {
}
