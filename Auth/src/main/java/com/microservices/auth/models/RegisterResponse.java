package com.microservices.auth.models;

public class RegisterResponse {
    private String id;
    private String email;
    private String nome;
    private String cognome;

    // Costruttore con parametri
    public RegisterResponse(String id, String email, String nome, String cognome) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
    }

    // Getter e Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
