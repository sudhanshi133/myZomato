package com.tekion.restaurant_management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "restaurants")
public class Restaurant {

    @Id
    private String id;
    
    private String tenantId;
    
    private String location;
    
    private boolean open;
    
    private Instant createdAt;

    public Restaurant() {
    }

    public Restaurant(String id, String tenantId, String location, boolean open) {
        this.id = id;
        this.tenantId = tenantId;
        this.location = location;
        this.open = open;
        this.createdAt = Instant.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}

