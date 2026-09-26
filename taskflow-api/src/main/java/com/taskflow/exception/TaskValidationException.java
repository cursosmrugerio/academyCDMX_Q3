package com.taskflow.exception;

/**
 * TaskValidationException — excepción CHECKED (extiende Exception) para reglas de
 * negocio violadas por input del usuario: algo esperable y recuperable en el CLI.
 *
 * Al ser checked, el compilador OBLIGA al menú a decidir qué hacer (avisar y volver
 * al menú) en vez de dejar que el programa reviente.
 *
 * Nombre y paquete canónicos de S1 (no cambian en toda la semana):
 * com.taskflow.exception.TaskValidationException.
 */
public class TaskValidationException extends Exception {

    public TaskValidationException(String mensaje) {
        super(mensaje);
    }
}
