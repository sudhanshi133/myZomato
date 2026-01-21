package com.tekion.dealer_management.controller;

import com.tekion.dealer_management.dto.CreateDealerRequest;
import com.tekion.dealer_management.dto.CreateTenantRequest;
import com.tekion.dealer_management.model.Dealer;
import com.tekion.dealer_management.model.Tenant;
import com.tekion.dealer_management.service.DealerService;
import com.tekion.dealer_management.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealers")
public class DealerController {
    
    @Autowired
    private DealerService dealerService;
    
    @Autowired
    private TenantService tenantService;
    
    @PostMapping
    public ResponseEntity<?> createDealer(@RequestBody CreateDealerRequest request) {
        try {
            Dealer dealer = dealerService.createDealer(request.dealerId);
            return ResponseEntity.status(HttpStatus.CREATED).body(dealer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{dealerId}")
    public ResponseEntity<?> getDealer(@PathVariable String dealerId) {
        try {
            Dealer dealer = dealerService.getDealer(dealerId);
            return ResponseEntity.ok(dealer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/{dealerId}/tenants")
    public ResponseEntity<?> createTenant(@PathVariable String dealerId, @RequestBody CreateTenantRequest request) {
        try {
            Tenant tenant = tenantService.createTenant(request.tenantId, dealerId, request.dbType);
            return ResponseEntity.status(HttpStatus.CREATED).body(tenant);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{dealerId}/tenants")
    public ResponseEntity<?> getTenantsByDealer(@PathVariable String dealerId) {
        try {
            List<Tenant> tenants = tenantService.getTenantsByDealer(dealerId);
            return ResponseEntity.ok(tenants);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

