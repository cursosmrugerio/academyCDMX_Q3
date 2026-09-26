package com.taskflow.repository;

import com.taskflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserRepository — creado en el integrador de D4 (paso 1). "Mañana lo usa el login": ese mañana es HOY
 * (S2D5, MP-4). Gana dos derived queries que el mundo de auth necesita:
 *   - findByUsername:   lo usa JpaUserDetailsService (login) y ProjectSecurity (regla de owner).
 *   - existsByUsername: lo usa AuthService.register para rechazar duplicados (409) sin traer la fila.
 * La gramática es la misma de D4 (findBy/existsBy + propiedad): Spring Data escribe el SQL.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /** Busca por el username único. Optional vacío si no existe (login -> UsernameNotFoundException). */
    Optional<User> findByUsername(String username);

    /** ¿Ya existe ese username? Cuenta en la BD, no trae la entidad (register -> 409 si true). */
    boolean existsByUsername(String username);
}
