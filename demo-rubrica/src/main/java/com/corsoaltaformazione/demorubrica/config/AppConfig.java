package com.corsoaltaformazione.demorubrica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.corsoaltaformazione.demorubrica.repository.Db;

@Configuration
public class AppConfig {

    @Bean
    public Db db() {
        return new Db();
    }
}
