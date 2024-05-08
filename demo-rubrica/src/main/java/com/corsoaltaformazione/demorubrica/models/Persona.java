package com.corsoaltaformazione.demorubrica.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // fa tutti i get
@Setter // fa tutti i set
@AllArgsConstructor // fa tutti i costruttori con i campi
@NoArgsConstructor // fa tutti i costruttori vuoti
public class Persona {
    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;
    private String numTel;
    private List<Tag> tags;
}
