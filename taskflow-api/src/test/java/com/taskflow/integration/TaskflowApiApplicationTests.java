package com.taskflow.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * TaskflowApiApplicationTests — el test de humo del cableo (contextLoads del Initializr). SON
 * integración (arranca TODO el contexto): hoy se muda a integration/ (integrador, paso 1).
 *
 * @ActiveProfiles("test"): H2 EN MEMORIA del perfil test — NO escribe en data/taskflow.mv.db.
 */
@SpringBootTest
@ActiveProfiles("test")
class TaskflowApiApplicationTests {

    @Test
    void contextLoads() {
    }
}
