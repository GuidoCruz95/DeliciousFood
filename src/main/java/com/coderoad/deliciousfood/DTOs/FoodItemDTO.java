package com.coderoad.deliciousfood.DTOs;

import com.coderoad.deliciousfood.models.FoodItem;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodItemDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    public FoodItem getModel() {
        FoodItem foodItem = new FoodItem();
        foodItem.setName(this.name);
        foodItem.setDescription(this.description);
        foodItem.setPrice(this.price.doubleValue());
        foodItem.setImageUrl(this.imageUrl);
        return foodItem;
    }
}
