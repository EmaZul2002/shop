package com.microservices.auth.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Annotazione per definire la collezione nel database MongoDB
@Document(collection = "users")
public class User {

    @Id // Indica l'ID del documento
    private String id;
    
    private String username;
    private String password;
    private String roles;

    // Costruttore senza parametri (richiesto da framework come Spring Data)
    public User() {
    }

    // Costruttore con parametri
    public User(String id, String username, String password, String roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // Getter e Setter per ogni campo

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    // Override del metodo toString (opzionale, utile per debug)
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
