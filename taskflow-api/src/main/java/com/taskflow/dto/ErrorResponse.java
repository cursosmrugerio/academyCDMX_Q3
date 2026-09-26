package com.taskflow.dto;

import java.time.Instant;
import java.util.List;

/**
 * ErrorResponse — el cuerpo JSON UNIFORME de todos los errores de la API (PM, MP-7). Un solo formato
 * para 400/404/422/500: nada de que cada excepción invente su respuesta.
 *
 *   { "timestamp": "...", "status": 400, "message": "...", "errors": ["campo: motivo", ...] }
 *
 * 'errors' lleva el detalle POR CAMPO de Bean Validation (MethodArgumentNotValidException); en los
 * errores sin detalle de campo (404, 422, JSON malformado) va como lista vacía.
 *
 * Awareness (1 min): Spring trae ProblemDetail (RFC 9457) como formato estándar del mundo real; el
 * capstone practica con su propio ErrorResponse para ejercitar el advice a mano.
 */
public record ErrorResponse(
        Instant timestamp,
        int status,
        String message,
        List<String> errors
) {
}
