package com.taskflow.service;

import com.taskflow.model.User;
import com.taskflow.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * JpaUserDetailsService — el punto donde Spring Security DEJA de inventar usuarios y consulta NUESTRA
 * tabla users (MP-4). Implementa el contrato UserDetailsService: loadUserByUsername -> UserDetails.
 *
 * Termómetro del día (punto de dolor 9): en cuanto este bean queda registrado (@Service, dentro del
 * component scan), el password generado DESAPARECE de la consola. Si sigue saliendo, este bean no se
 * registró.
 *
 * hasRole/prefijo (punto de dolor 5): hasRole("ADMIN") espera la authority ROLE_ADMIN. El builder
 * .roles(role.name()) AÑADE el prefijo ROLE_ por nosotros — olvidarlo produce el "403 misterioso" con
 * un token válido.
 */
@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No existe usuario con username: " + username));

        // org.springframework.security.core.userdetails.User (el UserDetails de Spring, NO nuestra
        // entidad): username + el HASH guardado + el rol como authority ROLE_<rol>.
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPasswordHash())      // el hash BCrypt de la BD; el AuthenticationManager compara con matches()
                .roles(user.getRole().name())          // USER -> ROLE_USER, ADMIN -> ROLE_ADMIN
                .build();
    }
}
