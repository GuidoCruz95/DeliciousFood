package com.coderoad.deliciousfood.controllers;


import com.coderoad.deliciousfood.DTOs.FoodItemDTO;
import com.coderoad.deliciousfood.models.FoodItem;
import com.coderoad.deliciousfood.services.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FoodItemDTO create(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItem foodItem = foodItemService.create(foodItemDTO.getModel());
        return foodItem.getDTO();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<FoodItemDTO> getByRestaurant(@PathVariable Long restaurantId) {
        return foodItemService.getByRestaurant(restaurantId).stream()
                .map(FoodItem::getDTO)
                .toList();
    }
}