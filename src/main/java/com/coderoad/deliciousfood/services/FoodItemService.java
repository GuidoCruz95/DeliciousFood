package com.coderoad.deliciousfood.services;

import com.coderoad.deliciousfood.models.FoodItem;
import com.coderoad.deliciousfood.repositories.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing food items in the system.
 */
@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    /**
     * Constructor to inject the FoodItemRepository.
     *
     * @param foodItemRepository the repository for FoodItem
     */
    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    /**
     * Creates and saves a new FoodItem.
     *
     * @param foodItem the food item to be created
     * @return the saved FoodItem entity
     */
    public FoodItem create(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    /**
     * Retrieves all food items associated with a specific restaurant.
     *
     * @param restaurantId the ID of the restaurant
     * @return a list of FoodItem entities belonging to the restaurant
     */
    public List<FoodItem> getByRestaurant(Long restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }

    /**
     * Retrieves a FoodItem by its ID.
     *
     * @param id the ID of the food item
     * @return an Optional containing the FoodItem if found, otherwise empty
     */
    public Optional<FoodItem> getById(Long id) {
        return foodItemRepository.findById(id);
    }
}