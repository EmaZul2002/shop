package com.microservices.auth.services;

import com.microservices.auth.services.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.io.IOException;

@WebFilter("/*")
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    public JwtAuthFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String token = getJwtFromRequest(request);

        if (token != null && jwtUtils.validateToken(token, getUsernameFromToken(token))) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    getUsernameFromToken(token),
                    null,
                    null // Non hai bisogno di passare authorities se non sono richieste
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    // Estrae il token JWT dal header Authorization
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    // Estrae il nome utente dal token (subject)
    private String getUsernameFromToken(String token) {
        return jwtUtils.extractUsername(token);
    }
}
