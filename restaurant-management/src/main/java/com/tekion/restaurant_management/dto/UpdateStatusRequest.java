package com.tekion.restaurant_management.dto;

import jakarta.validation.constraints.NotNull;

public class UpdateStatusRequest {

    @NotNull(message = "Open status is required")
    private Boolean open;

    public UpdateStatusRequest() {
    }

    public UpdateStatusRequest(Boolean open) {
        this.open = open;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}

