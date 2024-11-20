package com.microservices.order.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disabilita CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/orders/**").authenticated() // Proteggi gli endpoint degli ordini
                .anyRequest().permitAll() // Permetti altri endpoint (se necessario)
            );
        return http.build();
    }
}
