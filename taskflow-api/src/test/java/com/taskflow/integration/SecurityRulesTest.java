package com.taskflow.integration;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * SecurityRulesTest — INTEGRACIÓN: la seguridad se prueba DONDE VIVE (decisión canónica de S3D1: el
 * slice NO prueba seguridad — la prueba el contexto completo con token real). Patrón canónico: TOKEN
 * REAL en el setup (login vía MockMvc contra los usuarios semilla) con el helper tokenDe. NO se usa
 * @WithMockUser porque brincaría el filtro JWT, el artefacto que se construyó en S2D5.
 *
 * Cierra la tabla 401 vs 403 con evidencia (sin token 401; con token 200; luis no-owner 403; owner/admin
 * 204). Hoy solo cambió de paquete (a integration/) y ganó el parametrizado de rutas protegidas.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class SecurityRulesTest {

    @Autowired
    private MockMvc mockMvc;

    /** Helper: login real contra un usuario semilla; devuelve su JWT. */
    private String tokenDe(String username, String password) throws Exception {
        String body = """
                { "username": "%s", "password": "%s" }
                """.formatted(username, password);
        String json = mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        return JsonPath.read(json, "$.token");
    }

    /**
     * Integrador (refactor a) — rutas protegidas SIN token -> 401, en un solo parametrizado. Cada ruta
     * es un test independiente en el reporte; añadir una ruta protegida = añadir un string, no un método.
     */
    @ParameterizedTest(name = "GET {0} sin token → 401")
    @ValueSource(strings = {"/projects", "/tasks", "/projects/1/tasks"})
    void rutaProtegida_sinToken_devuelve401(String ruta) throws Exception {
        mockMvc.perform(get(ruta))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void getProjects_conTokenDeAna_devuelve200() throws Exception {
        String token = tokenDe("ana", "ana123");
        mockMvc.perform(get("/projects").header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    @Test
    void deleteProject_comoLuisNoOwner_devuelve403() throws Exception {
        // luis (USER) no es owner del proyecto 1 (es de ana) ni ADMIN -> 403 (NO 401: la API sabe quién es).
        String token = tokenDe("luis", "luis123");
        mockMvc.perform(delete("/projects/1").header("Authorization", "Bearer " + token))
                .andExpect(status().isForbidden());
    }

    @Test
    void deleteProject_comoAnaOwner_devuelve204() throws Exception {
        String token = tokenDe("ana", "ana123");
        mockMvc.perform(delete("/projects/1").header("Authorization", "Bearer " + token))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteProject_comoAdmin_devuelve204() throws Exception {
        String token = tokenDe("admin", "admin123");
        mockMvc.perform(delete("/projects/1").header("Authorization", "Bearer " + token))
                .andExpect(status().isNoContent());
    }

    /**
     * STRETCH — token MANIPULADO: se altera un carácter de la firma. El parser lanza DENTRO del filtro
     * JWT; el try/catch del filtro responde 401 (no 500).
     */
    @Test
    void getProjects_conTokenManipulado_devuelve401() throws Exception {
        String token = tokenDe("ana", "ana123");
        String[] parts = token.split("\\.");
        char[] firma = parts[2].toCharArray();
        firma[0] = (firma[0] == 'A') ? 'B' : 'A';
        String manipulado = parts[0] + "." + parts[1] + "." + new String(firma);
        mockMvc.perform(get("/projects").header("Authorization", "Bearer " + manipulado))
                .andExpect(status().isUnauthorized());
    }
}
