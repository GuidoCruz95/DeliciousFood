package com.coderoad.deliciousfood.models;

import com.coderoad.deliciousfood.DTOs.RestaurantDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String ownerName;
    private String cellphone;
    private String category;

    private BillingInfo billingInfo;

    @Embedded
    private Location location;

    @OneToMany(mappedBy = "restaurant")
    private List<FoodItem> menu;

    public RestaurantDTO getDTO() {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setName(this.name);
        dto.setOwnerName(this.ownerName);
        dto.setCellphone(this.cellphone);
        dto.setCategory(this.category);
        dto.setBillingInfo(this.billingInfo);
        dto.setLocation(this.location);
        dto.setMenu(this.menu);
        return dto;
    }
}