package com.tekion.restaurant_management.service;

import com.tekion.restaurant_management.dto.CreateRestaurantRequest;
import com.tekion.restaurant_management.dto.UpdateStatusRequest;
import com.tekion.restaurant_management.exception.ResourceNotFoundException;
import com.tekion.restaurant_management.model.Restaurant;
import com.tekion.restaurant_management.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(String tenantId, CreateRestaurantRequest request) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(request.getId());
        restaurant.setTenantId(tenantId);
        restaurant.setLocation(request.getLocation());
        restaurant.setOpen(request.getOpen());
        restaurant.setCreatedAt(Instant.now());
        
        return restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurantById(String tenantId, String restaurantId) {
        return restaurantRepository.findByIdAndTenantId(restaurantId, tenantId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Restaurant not found with id: " + restaurantId + " for tenant: " + tenantId));
    }

    public List<Restaurant> getAllRestaurants(String tenantId) {
        return restaurantRepository.findByTenantId(tenantId);
    }

    public Restaurant updateRestaurantStatus(String tenantId, String restaurantId, UpdateStatusRequest request) {
        Restaurant restaurant = getRestaurantById(tenantId, restaurantId);
        restaurant.setOpen(request.getOpen());
        return restaurantRepository.save(restaurant);
    }
}

