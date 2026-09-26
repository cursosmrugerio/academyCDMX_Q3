package com.taskflow.model;

/**
 * Role — rol de un usuario. Es un enum, NO una jerarquía de herencia: el rol es un
 * conjunto cerrado de valores, no un tipo con comportamiento propio. (Aquí NO se
 * hereda: un enum es la herramienta correcta.)
 */
public enum Role {
    USER,
    ADMIN
}
