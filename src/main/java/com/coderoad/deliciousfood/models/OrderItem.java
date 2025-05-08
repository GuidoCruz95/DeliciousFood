package com.coderoad.deliciousfood.models;

import com.coderoad.deliciousfood.DTOs.OrderItemDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private FoodItem foodItem;

    private Integer quantity;

    public OrderItemDTO getDTO() {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setFoodItemId(this.foodItem != null ? this.foodItem.getId() : null);
        dto.setQuantity(this.quantity);
        return dto;
    }
}