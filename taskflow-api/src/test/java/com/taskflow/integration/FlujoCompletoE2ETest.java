package com.taskflow.integration;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * FlujoCompletoE2ETest — el test de INTEGRACIÓN de verdad (S3D1, MP-9). @SpringBootTest levanta TODO el
 * contexto (JPA, seguridad, seeder, advice) y automatiza PARA SIEMPRE la demo de pareja del viernes:
 * un solo test-viaje que prueba seguridad + advice + JPA + dominio JUNTOS, UNA vez. Esto es lo que el
 * slice ya NO necesita repetir (cada capa se prueba donde es barata; el flujo entero, una vez).
 *
 * Disciplina que QE S4 elevará a ley de CI: el test CREA SUS PROPIOS DATOS (register de un usuario nuevo)
 * — no depende de la semilla. Corre sobre H2 en memoria (perfil test); @Transactional -> rollback.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class FlujoCompletoE2ETest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void viajeCompleto_registerLoginCrearCompletarYVerificar() throws Exception {
        // 1) REGISTER — usuario propio nuevo (nada de semilla). La respuesta trae su id -> será el assignee.
        String registerBody = """
                {
                  "username": "e2e_maria",
                  "email": "e2e_maria@taskflow.dev",
                  "password": "maria123"
                }
                """;
        String registerJson = mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(registerBody))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        int usuarioId = JsonPath.read(registerJson, "$.id");

        // 2) LOGIN — extraer el token del JSON.
        String loginJson = mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                { "username": "e2e_maria", "password": "maria123" }
                                """))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        String token = JsonPath.read(loginJson, "$.token");
        String bearer = "Bearer " + token;

        // 3) CREAR PROYECTO (con Bearer) -> extraer su id.
        String proyectoJson = mockMvc.perform(post("/projects")
                        .header("Authorization", bearer)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                { "name": "Proyecto E2E", "description": "Viaje completo" }
                                """))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();
        int proyectoId = JsonPath.read(proyectoJson, "$.id");

        // 4) CREAR TAREA bajo el proyecto, asignada al usuario que devolvió register -> extraer su id.
        String tareaBody = """
                {
                  "title": "Preparar el release",
                  "description": "El primero end-to-end",
                  "priority": "HIGH",
                  "assigneeId": %d,
                  "dueDate": "2099-12-31"
                }
                """.formatted(usuarioId);
        String tareaJson = mockMvc.perform(post("/projects/" + proyectoId + "/tasks")
                        .header("Authorization", bearer)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tareaBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("TODO"))
                .andReturn().getResponse().getContentAsString();
        int tareaId = JsonPath.read(tareaJson, "$.id");

        // 5) PATCH a DONE (con assignee presente, la regla lo permite).
        mockMvc.perform(patch("/tasks/" + tareaId + "/status")
                        .header("Authorization", bearer)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"status\": \"DONE\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("DONE"));

        // 6) VERIFICAR: las tareas del proyecto muestran la tarea en DONE.
        mockMvc.perform(get("/projects/" + proyectoId + "/tasks").header("Authorization", bearer))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].status").value("DONE"));

        // 7) Bonus barato: GET /tasks (ejercita listar() -> POR_URGENCIA) responde 200 con el token.
        mockMvc.perform(get("/tasks").header("Authorization", bearer))
                .andExpect(status().isOk());
    }
}
