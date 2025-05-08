package com.coderoad.deliciousfood.repositories;

import com.coderoad.deliciousfood.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCategoryIgnoreCase(String category);
}