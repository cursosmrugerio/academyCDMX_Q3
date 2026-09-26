package com.taskflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TaskflowApiApplication — punto de entrada generado por Spring Initializr.
 *
 * @SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration. Lo que
 * importa HOY: @ComponentScan escanea el package de ESTA clase (com.taskflow) y TODOS sus
 * subpackages — por eso el dominio copiado y los @Repository/@Service/@Component viven bajo
 * com.taskflow y el contenedor los encuentra sin configurar nada.
 *
 * El main "raro" de una línea no hace nada visible por sí mismo: SpringApplication.run levanta el
 * CONTENEDOR, construye y cablea los beans, y ejecuta los CommandLineRunner. Ese contenedor es el
 * que en S1 era el 'new' a mano del Main de la consola: Spring construye y cablea por ti.
 */
@SpringBootApplication
public class TaskflowApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskflowApiApplication.class, args);
    }
}
