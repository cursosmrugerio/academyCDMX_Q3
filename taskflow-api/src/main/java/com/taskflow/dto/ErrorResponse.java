package com.taskflow.dto;

import java.time.Instant;
import java.util.List;

/**
 * ErrorResponse — el cuerpo JSON UNIFORME de todos los errores de la API. Un solo formato
 * para 400/404/422/500: nada de que cada excepción invente su respuesta.
 *
 *   { "timestamp": "...", "status": 400, "message": "...", "errors": ["campo: motivo", ...] }
 *
 * 'errors' lleva el detalle POR CAMPO de Bean Validation (MethodArgumentNotValidException); en los
 * errores sin detalle de campo (404, 422, JSON malformado) va como lista vacía.
 *
 * Alternativa: Spring trae ProblemDetail (RFC 9457) como formato estándar del mundo real; este
 * proyecto usa su propio ErrorResponse para que el advice quede escrito a mano, a la vista.
 */
public record ErrorResponse(
        Instant timestamp,
        int status,
        String message,
        List<String> errors
) {
}
