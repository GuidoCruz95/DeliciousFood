package com.coderoad.deliciousfood.services;

import com.coderoad.deliciousfood.models.FoodItem;
import com.coderoad.deliciousfood.models.Restaurant;
import com.coderoad.deliciousfood.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing restaurant-related operations such as registration, updating,
 * retrieving by category, and adding food items to the menu.
 */
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    /**
     * Constructs the RestaurantService with the required repository.
     *
     * @param restaurantRepository the repository for Restaurant entities
     */
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * Registers a new restaurant in the system.
     *
     * @param restaurant the restaurant to be registered
     * @return the saved Restaurant entity
     */
    public Restaurant register(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    /**
     * Retrieves all restaurants in a given category, case insensitive.
     *
     * @param category the category of restaurants to retrieve
     * @return a list of Restaurant entities that match the category
     */
    public List<Restaurant> getByCategory(String category) {
        return restaurantRepository.findByCategoryIgnoreCase(category);
    }

    /**
     * Updates an existing restaurant with new data.
     *
     * @param id                the ID of the restaurant to update
     * @param updatedRestaurant the new data for the restaurant
     * @return the updated Restaurant entity
     * @throws RuntimeException if the restaurant is not found
     */
    public Restaurant update(Long id, Restaurant updatedRestaurant) {
        Restaurant existing = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        existing.setName(updatedRestaurant.getName());
        existing.setOwnerName(updatedRestaurant.getOwnerName());
        existing.setCellphone(updatedRestaurant.getCellphone());
        existing.setCategory(updatedRestaurant.getCategory());
        existing.setBillingInfo(updatedRestaurant.getBillingInfo());
        existing.setLocation(updatedRestaurant.getLocation());
        existing.setMenu(updatedRestaurant.getMenu());

        return restaurantRepository.save(existing);
    }

    /**
     * Adds a list of new food items to an existing restaurant's menu.
     *
     * @param restaurantId the ID of the restaurant
     * @param newItems     the list of new food items to add
     * @return the updated Restaurant entity
     * @throws RuntimeException if the restaurant is not found
     */
    public Restaurant addFoodItems(Long restaurantId, List<FoodItem> newItems) {
        Restaurant existing = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        List<FoodItem> restaurantMenu = existing.getMenu();
        restaurantMenu.addAll(newItems);

        existing.setMenu(restaurantMenu);

        return restaurantRepository.save(existing);
    }
}