package com.microservices.auth.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    // Usa una chiave segreta per firmare i token
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Genera un token JWT con una durata di 1 giorno
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // Imposta il subject (il nome dell'utente)
                .setIssuedAt(new Date())  // Data di emissione del token
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Scadenza: 1 giorno (24 ore)
                .signWith(key, SignatureAlgorithm.HS256) // Firma il token usando la chiave
                .compact();
    }

    // Estrai il nome utente (subject) dal token JWT
    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    // Estrai la data di scadenza del token
    public Date extractExpiration(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getExpiration();
    }

    // Verifica se il token è scaduto
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Verifica se il token è valido (non scaduto e firma corretta)
    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }
}
