package com.softtek.java.academy.exceptions;

import java.util.UUID;


public class Product {
    
    private UUID id;
    
    private String description;

    
    public UUID getId() {
    
        return id;
    }

    
    public void setId(UUID uuid) {
    
        this.id = uuid;
    }

    
    public String getDescription() {
    
        return description;
    }

    
    public void setDescription(String description) {
    
        this.description = description;
    }

}
