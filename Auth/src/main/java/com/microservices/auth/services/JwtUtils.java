package com.microservices.auth.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    private static final Key key = Keys.hmacShaKeyFor("abcdefghijklmnopqrtuvwxyz1234567890".getBytes());

    public String generateToken(String email, String userId) {
        return Jwts.builder()
                .setSubject(email) // Imposta l'email come subject
                .claim("id", userId) // Inserisce l'ID utente come claim
                .setIssuedAt(new Date()) // Data di emissione
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Data di scadenza
                .signWith(key, SignatureAlgorithm.HS256) // Firma il token con HMAC-SHA256
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            System.out.println("Token JWT non valido: " + ex.getMessage());
            return false;
        }
    }
    

    private boolean isTokenExpired(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }
}
