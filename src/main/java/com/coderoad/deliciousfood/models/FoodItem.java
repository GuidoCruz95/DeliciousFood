package com.coderoad.deliciousfood.models;

import com.coderoad.deliciousfood.DTOs.FoodItemDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class FoodItem {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String imageUrl;

    @ManyToOne
    private Restaurant restaurant;

    public FoodItemDTO getDTO() {
        FoodItemDTO dto = new FoodItemDTO();
        dto.setName(this.name);
        dto.setDescription(this.description);
        dto.setPrice(BigDecimal.valueOf(this.price));
        dto.setImageUrl(this.imageUrl);
        return dto;
    }
}