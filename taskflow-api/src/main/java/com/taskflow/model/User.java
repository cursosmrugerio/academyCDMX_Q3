package com.taskflow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * User — usuario del sistema. Entidad JPA desde D4 (de record a clase). HOY (S2D5, MP-3) gana el
 * campo que faltaba: passwordHash.
 *
 * @Table(name = "users") es OBLIGATORIO: 'USER' es palabra RESERVADA en H2 y Postgres (viene de D4).
 *
 * PAGA DE LA DEUDA DE S1D2: allá se declaró "User omite passwordHash — se añade en S2D5 (seguridad)".
 * No fue olvido, fue diseño: un password no se modela hasta que se puede HASHEAR. El campo se llama
 * passwordHash (columna password_hash) y NO 'password' porque el nombre DOCUMENTA que ahí jamás vive
 * un password en claro — solo su hash BCrypt (prefijo $2a$/$2b$, salt automático).
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    /**
     * El HASH BCrypt del password (NUNCA el password en claro). @JsonIgnore es un cinturón extra
     * (punto de dolor 8): aunque la disciplina de D3 dice "exponer siempre UserResponse, nunca la
     * entidad", si alguien serializara un User por error, este campo NO viajaría al JSON.
     */
    @JsonIgnore
    @Column(name = "password_hash")
    private String passwordHash;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    /** Constructor no-arg protegido: EXCLUSIVO de JPA. */
    protected User() {
        // solo para JPA
    }

    public User(Long id, String username, String passwordHash, String email, Role role) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        // toString NUNCA imprime el hash (buena higiene: nada de credenciales en logs).
        return "User{id=" + id + ", username='" + username + '\'' + ", role=" + role + '}';
    }
}
