package com.tekion.restaurant_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateRestaurantRequest {

    @NotBlank(message = "Restaurant ID is required")
    private String id;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Open status is required")
    private Boolean open;

    public CreateRestaurantRequest() {
    }

    public CreateRestaurantRequest(String id, String location, Boolean open) {
        this.id = id;
        this.location = location;
        this.open = open;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}

