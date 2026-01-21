package com.tekion.dealer_management.service;

import com.tekion.dealer_management.model.DbType;
import com.tekion.dealer_management.model.Tenant;
import com.tekion.dealer_management.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {
    
    @Autowired
    private TenantRepository tenantRepository;
    
    @Autowired
    private DealerService dealerService;
    
    public Tenant createTenant(String tenantId, String dealerId, DbType dbType) {
        if (!dealerService.dealerExists(dealerId)) {
            throw new IllegalArgumentException("Dealer with ID '" + dealerId + "' not found");
        }
        if (tenantRepository.existsById(tenantId)) {
            throw new IllegalArgumentException("Tenant with ID '" + tenantId + "' already exists");
        }
        DbType finalDbType = dbType != null ? dbType : DbType.SHARED;
        Tenant tenant = new Tenant(tenantId, dealerId, finalDbType);

        if (finalDbType == DbType.DEDICATED) {
            String dbConnection = "mongodb://localhost:27017/tenant_" + tenantId + "_db";
            tenant.setDbConnection(dbConnection);
        }

        return tenantRepository.save(tenant);
    }

    public Tenant getTenant(String tenantId) {
        return tenantRepository.findById(tenantId)
                .orElseThrow(() -> new IllegalArgumentException("Tenant with ID '" + tenantId + "' not found"));
    }

    public List<Tenant> getTenantsByDealer(String dealerId) {
        if (!dealerService.dealerExists(dealerId)) {
            throw new IllegalArgumentException("Dealer with ID '" + dealerId + "' not found");
        }
        
        return tenantRepository.findByDealerId(dealerId);
    }
}

