package com.corsoaltaformazione.demorubrica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.corsoaltaformazione.demorubrica.models.Persona;
import com.corsoaltaformazione.demorubrica.models.Tag;
import com.corsoaltaformazione.demorubrica.services.RubricaService;

@RequestMapping("/rubrica") //dice al framework di mappare i metodi di questa pagina sotto /rubrica (localhost:8080/rubrica)
@RestController //dice al framework che questa classe restituisce dati direttamente ad una pagina web
public class PersoneController {
    @Autowired //inietta automaticamente la dipendenza senza usare il new
    RubricaService rubricaService;

    @GetMapping("") // dice al framework che questo metodo deve rispondere quando l'url è vuoto dopo rubrica e è una get
    public @ResponseBody List<Persona> getAll(){
        return rubricaService.findAll();//ritorna tutti i numeri in rubrica
    }

    @GetMapping("/{id}") // dice al framework che questo metodo deve rispondere quando l'url è / un id ed è una get
    public Persona getById(@PathVariable String id){
        return rubricaService.findById(id); //non ancora sviluppato
    }

    @PostMapping("") // dice al framework che questo metodo deve rispondere quando l'url è vuoto ed è una post
    public @ResponseBody Persona save(@RequestBody Persona persona){ // prende dal body l'oggetto persona
        rubricaService.addPersona(persona); // salva la persona in rubrica
        return persona;
    }

    @DeleteMapping("/{email}") // dice al framework che questo metodo deve rispondere quando l'url è / un email ed è una delete
    public ResponseEntity<Boolean> delete(@PathVariable String email){
        rubricaService.deletePersona(email); // cancella la persona dalla rubrica
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @PostMapping("/{id}") // dice al framework che questo metodo deve rispondere quando l'url è / un id ed è una get
    public Persona addTag(@PathVariable String id, @RequestBody List<Tag> tags){
        System.out.println(tags);
        List<Tag> tmp = rubricaService.findById(id).getTags();
        if(tmp.isEmpty()){
            tmp=tags;
        }else{
            tmp.addAll(tags);
        }
        System.out.println(tmp);
        rubricaService.findById(id).setTags(tmp);
        return rubricaService.findById(id); //non ancora sviluppato
    }

}
