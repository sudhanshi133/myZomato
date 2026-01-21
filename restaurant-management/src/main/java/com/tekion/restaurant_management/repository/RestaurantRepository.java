package com.tekion.restaurant_management.repository;

import com.tekion.restaurant_management.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    
    List<Restaurant> findByTenantId(String tenantId);
    
    Optional<Restaurant> findByIdAndTenantId(String id, String tenantId);
}

