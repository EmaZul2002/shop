package com.corsoaltaformazione.demorubrica.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;
    private List<Tag> tags;
}
