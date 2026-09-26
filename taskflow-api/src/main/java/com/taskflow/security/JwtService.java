package com.taskflow.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * JwtService — el SERVICIO DE TOKENS. Es PROVISTO y COMPLETO: hoy se LEE y se USA, no se escribe
 * (MP-7, lectura guiada). Criptografía APLICADA no es objetivo del curso; usarla bien, sí. jjwt
 * (versión 0.12.6) hace el trabajo pesado; nosotros elegimos qué guardar y cómo validar.
 *
 * Un JWT tiene 3 partes separadas por puntos: header.payload.signature (base64url). El payload es
 * LEGIBLE (base64, NO cifrado) — la firma protege INTEGRIDAD (nadie lo altera sin el secret), no
 * secreto. Regla: NUNCA metas datos sensibles en los claims.
 *
 * Claims que emitimos:
 *   - sub (subject) = el username (a quién identifica el token).
 *   - role          = la authority principal (informativo; la autorización REAL la manda la BD).
 *   - iat (issuedAt) / exp (expiration) = emitido en / expira en (ventana de validez).
 */
@Service
public class JwtService {

    /** Clave HMAC derivada del secret. HS256 exige >= 256 bits (32+ chars) o lanza WeakKeyException. */
    private final SecretKey key;

    /** Vigencia del token en milisegundos (jwt.expiration-ms; 3600000 = 1 h). */
    private final long expirationMs;

    public JwtService(@Value("${jwt.secret}") String secret,
                      @Value("${jwt.expiration-ms}") long expirationMs) {
        // Los bytes UTF-8 del secret son la clave simétrica. En prod el secret vive en una variable de
        // entorno (S3, 12-factor), NUNCA en el yml commiteado.
        this.key = io.jsonwebtoken.security.Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = expirationMs;
    }

    /**
     * Genera un token firmado para un usuario ya autenticado. subject = username; claim 'role' con la
     * primera authority (informativo); iat = ahora, exp = ahora + expirationMs. signWith(key) elige
     * HS256 automáticamente para una clave de 256 bits. compact() serializa a la cadena de 3 partes.
     */
    public String generateToken(UserDetails user) {
        Date ahora = new Date();
        Date expira = new Date(ahora.getTime() + expirationMs);
        String role = user.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse("");
        return Jwts.builder()
                .subject(user.getUsername())     // sub
                .claim("role", role)             // claim informativo
                .issuedAt(ahora)                 // iat
                .expiration(expira)              // exp
                .signWith(key)                   // firma HS256 con nuestro secret
                .compact();
    }

    /** Extrae el username (subject) del token. Si el token es inválido/expirado, jjwt LANZA (JwtException). */
    public String extractUsername(String token) {
        return parseClaims(token).getSubject();
    }

    /**
     * true si el token es de ESTE usuario y aún no expira. Nota: si el token estuviera expirado,
     * parseClaims ya habría lanzado ExpiredJwtException antes de llegar aquí (el filtro lo captura).
     */
    public boolean isTokenValid(String token, UserDetails user) {
        final String username = extractUsername(token);
        return username.equals(user.getUsername()) && !estaExpirado(token);
    }

    private boolean estaExpirado(String token) {
        return parseClaims(token).getExpiration().before(new Date());
    }

    /**
     * Parsea Y VERIFICA la firma. clockSkewSeconds(60) tolera 60 s de desfase de reloj (punto de dolor
     * 4, típico en Windows): si el desfase es mayor, se arregla el RELOJ, no se sube el skew. Si la
     * firma no cuadra o el token está corrupto/expirado, lanza una subclase de JwtException.
     */
    private Claims parseClaims(String token) {
        return Jwts.parser()
                .clockSkewSeconds(60)
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
