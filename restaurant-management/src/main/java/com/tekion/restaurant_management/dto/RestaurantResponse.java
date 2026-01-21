package com.tekion.restaurant_management.dto;

import com.tekion.restaurant_management.model.Restaurant;

import java.time.Instant;

public class RestaurantResponse {

    private String id;
    private String tenantId;
    private String location;
    private boolean open;
    private Instant createdAt;

    public RestaurantResponse() {
    }

    public RestaurantResponse(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.tenantId = restaurant.getTenantId();
        this.location = restaurant.getLocation();
        this.open = restaurant.isOpen();
        this.createdAt = restaurant.getCreatedAt();
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

