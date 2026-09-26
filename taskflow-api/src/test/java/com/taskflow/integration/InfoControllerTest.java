package com.taskflow.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * InfoControllerTest — el test del PR de prueba de S3D4 (integrador, fase 2).
 *
 * Es de INTEGRACIÓN a propósito (contexto completo con la cadena de seguridad REAL), no un slice: lo
 * que se prueba NO es el JSON, es que /info sea PÚBLICO. Patrón de S2D5: @SpringBootTest + MockMvc,
 * perfil test (H2 en memoria). Se escribe PRIMERO, con la expectativa "200 SIN token"; sin la línea
 * permitAll("/info") en SecurityConfig el endpoint hereda anyRequest().authenticated() y responde 401
 * -> el test ROJO obliga a añadir el permitAll (TDD relámpago). Con la línea puesta: verde.
 *
 * Sin @Transactional: /info no toca la BD, no hay estado que revertir.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class InfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getInfo_sinToken_devuelve200ConAppYVersion() throws Exception {
        // SIN header Authorization: /info debe ser público (permitAll). Si falta la regla -> 401 y el test cae.
        mockMvc.perform(get("/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.app").value("taskflow-api"))
                .andExpect(jsonPath("$.version").value("3.0.0"));   // FREEZE S3D5: el assert sigue al bump del controller
    }
}
