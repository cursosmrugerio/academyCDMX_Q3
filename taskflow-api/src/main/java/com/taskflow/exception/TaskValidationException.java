package com.taskflow.exception;

/**
 * TaskValidationException — excepción CHECKED (extiende Exception) para reglas de
 * negocio violadas por input del usuario: algo esperable y recuperable.
 *
 * Al ser checked, el compilador OBLIGA a quien la recibe a decidir qué hacer en vez de
 * dejar que el programa reviente: declararla con throws y dejarla subir (el
 * GlobalExceptionHandler la responde como 400) o capturarla y traducirla (TaskService.
 * cambiarStatus la convierte en TaskStateException -> 422).
 */
public class TaskValidationException extends Exception {

    public TaskValidationException(String mensaje) {
        super(mensaje);
    }
}
