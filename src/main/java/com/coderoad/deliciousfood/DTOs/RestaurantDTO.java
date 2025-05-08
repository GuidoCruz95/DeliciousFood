package com.coderoad.deliciousfood.DTOs;

import com.coderoad.deliciousfood.models.BillingInfo;
import com.coderoad.deliciousfood.models.FoodItem;
import com.coderoad.deliciousfood.models.Location;
import com.coderoad.deliciousfood.models.Restaurant;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantDTO {

    private String name;
    private String ownerName;
    private String cellphone;
    private String category;
    private BillingInfo billingInfo;
    private Location location;
    private List<FoodItem> menu;

    public Restaurant getModel() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(this.name);
        restaurant.setOwnerName(this.ownerName);
        restaurant.setCellphone(this.cellphone);
        restaurant.setCategory(this.category);
        restaurant.setBillingInfo(this.billingInfo);
        restaurant.setLocation(this.location);
        restaurant.setMenu(this.menu);
        return restaurant;
    }
}
