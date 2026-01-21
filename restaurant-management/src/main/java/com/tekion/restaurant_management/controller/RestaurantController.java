package com.tekion.restaurant_management.controller;

import com.tekion.restaurant_management.dto.CreateRestaurantRequest;
import com.tekion.restaurant_management.dto.RestaurantResponse;
import com.tekion.restaurant_management.dto.UpdateStatusRequest;
import com.tekion.restaurant_management.model.Restaurant;
import com.tekion.restaurant_management.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private static final String TENANT_HEADER = "X-TENANT-ID";

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(@RequestHeader(TENANT_HEADER) String tenantId, @Valid @RequestBody CreateRestaurantRequest request) {
        
        Restaurant restaurant = restaurantService.createRestaurant(tenantId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RestaurantResponse(restaurant));
    }

    @GetMapping("/{restaurantId}")

    public ResponseEntity<RestaurantResponse> getRestaurantById(
            @RequestHeader(TENANT_HEADER) String tenantId,
            @PathVariable String restaurantId) {
        
        Restaurant restaurant = restaurantService.getRestaurantById(tenantId, restaurantId);
        return ResponseEntity.ok(new RestaurantResponse(restaurant));
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurants(@RequestHeader(TENANT_HEADER) String tenantId) {
        
        List<Restaurant> restaurants = restaurantService.getAllRestaurants(tenantId);
        List<RestaurantResponse> response = restaurants.stream()
                .map(RestaurantResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{restaurantId}/status")
    public ResponseEntity<RestaurantResponse> updateRestaurantStatus(
            @RequestHeader(TENANT_HEADER) String tenantId,
            @PathVariable String restaurantId,
            @Valid @RequestBody UpdateStatusRequest request) {
        
        Restaurant restaurant = restaurantService.updateRestaurantStatus(tenantId, restaurantId, request);
        return ResponseEntity.ok(new RestaurantResponse(restaurant));
    }
}

