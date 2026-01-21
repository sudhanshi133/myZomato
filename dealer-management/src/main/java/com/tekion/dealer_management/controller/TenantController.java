package com.tekion.dealer_management.controller;

import com.tekion.dealer_management.model.Tenant;
import com.tekion.dealer_management.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenants")
public class TenantController {
    
    @Autowired
    private TenantService tenantService;
    
    @GetMapping("/{tenantId}")
    public ResponseEntity<?> getTenant(@PathVariable String tenantId) {
        try {
            Tenant tenant = tenantService.getTenant(tenantId);
            return ResponseEntity.ok(tenant);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

