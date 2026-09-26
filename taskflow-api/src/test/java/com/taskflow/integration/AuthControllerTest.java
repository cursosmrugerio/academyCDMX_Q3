package com.taskflow.integration;

import com.taskflow.model.User;
import com.taskflow.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * AuthControllerTest — INTEGRACIÓN (register/login sobre el contexto completo). SON integración: tocan
 * seguridad + JPA + advice reales; por eso hoy VIVEN en integration/ (solo se mudó el paquete, el
 * contenido es el de S2D5). @SpringBootTest + MockMvc, perfil test (H2 en memoria), @Transactional.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    void register_usuarioNuevo_devuelve201HasheaYNoDevuelvePassword() throws Exception {
        String body = """
                {
                  "username": "carla",
                  "email": "carla@taskflow.dev",
                  "password": "carla123"
                }
                """;

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("carla"))
                .andExpect(jsonPath("$.role").value("USER"))
                .andExpect(jsonPath("$.passwordHash").doesNotExist());

        User guardado = userRepository.findByUsername("carla").orElseThrow();
        assertThat(guardado.getPasswordHash()).startsWith("$2");
        assertThat(guardado.getPasswordHash()).isNotEqualTo("carla123");
    }

    @Test
    void register_usernameDuplicado_devuelve409() throws Exception {
        String body = """
                {
                  "username": "ana",
                  "email": "otra-ana@taskflow.dev",
                  "password": "otro-pass"
                }
                """;

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.status").value(409));
    }

    @Test
    void login_credencialesValidas_devuelve200ConToken() throws Exception {
        String body = """
                { "username": "ana", "password": "ana123" }
                """;

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value(matchesPattern("[^.]+\\.[^.]+\\.[^.]+")));
    }

    @Test
    void login_passwordMalo_devuelve401() throws Exception {
        String body = """
                { "username": "ana", "password": "password-incorrecto" }
                """;

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.status").value(401));
    }
}
