package com.coderoad.deliciousfood.controllers;


import com.coderoad.deliciousfood.DTOs.FoodItemDTO;
import com.coderoad.deliciousfood.DTOs.RestaurantDTO;
import com.coderoad.deliciousfood.models.Restaurant;
import com.coderoad.deliciousfood.services.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantDTO register(@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantService.register(restaurantDTO.getModel());
        return restaurant.getDTO();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDTO> update(@PathVariable Long id, @RequestBody RestaurantDTO restaurantDTO) {
        Restaurant updated = restaurantService.update(id, restaurantDTO.getModel());
        return ResponseEntity.ok(updated.getDTO());
    }

    @PutMapping("/add-menu/{restaurantId}")
    public ResponseEntity<RestaurantDTO> addFoodOffering(@PathVariable Long restaurantId, @RequestBody List<FoodItemDTO> foodItems) {
        Restaurant updated = restaurantService.addFoodItems(
                restaurantId,
                foodItems.stream()
                        .map(FoodItemDTO::getModel)
                        .collect(Collectors.toList())
        );
        return ResponseEntity.ok(updated.getDTO());
    }

    @GetMapping("/category/{category}")
    public List<RestaurantDTO> getByCategory(@PathVariable String category) {
        return restaurantService.getByCategory(category).stream()
                .map(Restaurant::getDTO)
                .toList();
    }
}