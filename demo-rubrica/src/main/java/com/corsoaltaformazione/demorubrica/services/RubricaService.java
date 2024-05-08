package com.corsoaltaformazione.demorubrica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corsoaltaformazione.demorubrica.models.Persona;
import com.corsoaltaformazione.demorubrica.models.Tag;
import com.corsoaltaformazione.demorubrica.repository.Db;

@Service //indica che questa classe fornisce un servizio/funzionalità all'interno dell'app
public class RubricaService {
    @Autowired //inietta automaticamente la dipendenza senza usare il new
    private Db db;

    // metodo che fa la put sul db data la persona
    public void addPersona(Persona persona){
        db.getDb().put(persona.getEmail(), persona);
    }
    // metodo che fa la delete sul db data l'email
    public void deletePersona(String email){
        db.getDb().remove(email);
    }
    // metodo che fa la get all sul db data la persona
    public List<Persona> findAll(){
        return db.getDb().values().stream().toList();
    }

    // metodo che fa la get sul db dato l'id
    public Persona findById(String id){
        return db.getDb().get(id);
    }

    public Persona getPersona(String nome, String cognome,String email, String indirizzo, String numTel, List<Tag> tags){
        Persona tmp = new Persona(nome, cognome, email, indirizzo, numTel, tags);
        return db.getDb().get(tmp);
    }
}
