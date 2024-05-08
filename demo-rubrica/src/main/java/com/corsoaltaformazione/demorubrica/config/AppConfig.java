package com.corsoaltaformazione.demorubrica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.corsoaltaformazione.demorubrica.repository.Db;

@Configuration //questo decorator dice che questa classe può inizializzare i Bean
public class AppConfig {

    @Bean //questo decorator dice che il ciclo di vita di questo oggetto viene gestito da spring
    public Db db() {
        return new Db();
    }
}
