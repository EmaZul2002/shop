package com.corsoaltaformazione.demorubrica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corsoaltaformazione.demorubrica.models.Persona;
import com.corsoaltaformazione.demorubrica.repository.Db;

@Service
public class RubricaService {
    @Autowired
    private Db db;

    public void addPersona(Persona persona){
        db.getDb().put(persona.getEmail(), persona);
    }
    public void deletePersona(String email){
        db.getDb().remove(email);
    }
    public List<Persona> findAll(){
        return db.getDb().values().stream().toList();
    }

}
