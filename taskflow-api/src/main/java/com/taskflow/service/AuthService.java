package com.taskflow.service;

import com.taskflow.dto.auth.AuthResponse;
import com.taskflow.dto.auth.LoginRequest;
import com.taskflow.dto.auth.RegisterRequest;
import com.taskflow.dto.auth.UserResponse;
import com.taskflow.exception.UsernameAlreadyExistsException;
import com.taskflow.model.Role;
import com.taskflow.model.User;
import com.taskflow.repository.UserRepository;
import com.taskflow.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * AuthService — el negocio de /auth (MP-5 register/login, MP-7 token real).
 *
 * register: si el username existe -> UsernameAlreadyExistsException (409 vía advice); si no, HASHEA el
 * password con BCrypt, guarda el User (rol USER por default) y devuelve UserResponse (SIN passwordHash).
 *
 * login: delega en el AuthenticationManager (verifica credenciales contra la tabla users con BCrypt);
 * credenciales malas -> BadCredentialsException (401 vía advice). Si pasan, emite el JWT real.
 */
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    /** Alta de usuario. 201 con UserResponse (el hash nunca sale). Username duplicado -> 409. */
    public UserResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new UsernameAlreadyExistsException(request.username());
        }
        String passwordHash = passwordEncoder.encode(request.password());   // BCrypt: nunca en claro
        User nuevo = new User(null, request.username(), passwordHash, request.email(), Role.USER);
        User guardado = userRepository.save(nuevo);
        return new UserResponse(guardado.getId(), guardado.getUsername(),
                guardado.getEmail(), guardado.getRole());
    }

    /**
     * Login. El AuthenticationManager (PROVISTO en SecurityConfig) autentica con UsernamePassword;
     * si las credenciales fallan lanza BadCredentialsException (401). Si pasan, el principal es el
     * UserDetails cargado por JpaUserDetailsService -> generateToken produce el JWT real (MP-7: aquí
     * MURIÓ el stub "pendiente-jwt").
     */
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);
        return new AuthResponse(token);
    }
}
