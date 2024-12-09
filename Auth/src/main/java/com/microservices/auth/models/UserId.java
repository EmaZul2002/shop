package com.microservices.auth.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class UserId {

    private String id;

    // Getters e Setters
    public String getId() {
        return id;
    }

    public UserId(String id) {
        this.id = id;
    }
}
