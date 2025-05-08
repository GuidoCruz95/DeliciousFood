package com.coderoad.deliciousfood.repositories;

import com.coderoad.deliciousfood.models.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findByRestaurantId(Long restaurantId);
}