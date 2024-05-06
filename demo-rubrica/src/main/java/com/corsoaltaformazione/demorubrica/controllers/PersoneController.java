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
import com.corsoaltaformazione.demorubrica.services.RubricaService;

@RequestMapping("/rubrica")
@RestController
public class PersoneController {
    @Autowired
    RubricaService rubricaService;

    @GetMapping("")
    public @ResponseBody List<Persona> getAll(){
        return rubricaService.findAll();
    }

    @GetMapping("/{id}")
    public Persona getById(String id){
        return null;
    }

    @PostMapping("")
    public @ResponseBody Persona save(@RequestBody Persona persona){
        rubricaService.addPersona(persona);
        return persona;
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Boolean> delete(@PathVariable String email){
        rubricaService.deletePersona(email);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
