package com.taskflow.controller;

import com.taskflow.dto.auth.AuthResponse;
import com.taskflow.dto.auth.LoginRequest;
import com.taskflow.dto.auth.RegisterRequest;
import com.taskflow.dto.auth.UserResponse;
import com.taskflow.model.User;
import com.taskflow.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController — la puerta HTTP de la autenticación (MP-5). Bajo /auth (público en el filter chain).
 *   - POST /auth/register -> 201 con UserResponse (sin passwordHash).
 *   - POST /auth/login    -> 200 con AuthResponse(token).
 *   - GET  /auth/me       -> STRETCH: el UserResponse del usuario del token.
 * Delega TODO en AuthService; la validación de forma la dispara @Valid (400 vía el advice de D3).
 */
@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Registro, login (devuelve JWT) y datos del usuario autenticado.")
public class AuthController {

    private final com.taskflow.service.AuthService authService;
    private final UserRepository userRepository;   // solo para el stretch /auth/me

    public AuthController(com.taskflow.service.AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    /** POST /auth/register — 201 con UserResponse. Username duplicado -> 409 (advice). */
    @SecurityRequirements   // publico: exigir token para registrarse seria circular
    @Operation(summary = "Registra un usuario",
            description = "El password viaja una vez y se guarda hasheado (BCrypt). Nunca se devuelve.")
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request) {
        UserResponse creado = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    /** POST /auth/login — 200 con AuthResponse(token). Credenciales malas -> 401 (advice). */
    @SecurityRequirements   // publico: es el endpoint que ENTREGA el token
    @Operation(summary = "Autentica y devuelve un JWT",
            description = "Manda el token en 'Authorization: Bearer <token>' en los demás endpoints.")
    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }

    /**
     * STRETCH — GET /auth/me: devuelve el UserResponse del usuario del token. Resuelve el username
     * desde el Authentication (lo puso el JwtAuthenticationFilter); no recibe ningún id del cliente.
     */
    @Operation(summary = "STRETCH: datos del usuario autenticado",
            description = "Lee el username del token (Authentication), no un id del cliente.")
    @GetMapping("/me")
    public UserResponse me(Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new UsernameNotFoundException(authentication.getName()));
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole());
    }
}
