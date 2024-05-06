package com.corsoaltaformazione.demorubrica.repository;

import java.util.HashMap;
import java.util.Map;

import com.corsoaltaformazione.demorubrica.models.Persona;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Db {
    public Map<String, Persona> db = new HashMap<>();
}
