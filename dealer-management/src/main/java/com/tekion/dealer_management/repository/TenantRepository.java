package com.tekion.dealer_management.repository;

import com.tekion.dealer_management.model.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRepository extends MongoRepository<Tenant, String> {
    List<Tenant> findByDealerId(String dealerId);
}

