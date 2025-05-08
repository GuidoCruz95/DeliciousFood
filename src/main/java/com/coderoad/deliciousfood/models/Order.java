package com.coderoad.deliciousfood.models;

import com.coderoad.deliciousfood.DTOs.OrderDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private DeliveryMan deliveryMan;

    private LocalDateTime orderTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Embedded
    private Location deliveryLocation;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public OrderDTO getDTO() {
        OrderDTO dto = new OrderDTO();
        dto.setUserId(this.user != null ? this.user.getId() : null);
        dto.setRestaurantId(this.restaurant != null ? this.restaurant.getId() : null);
        dto.setDeliveryAddress(this.deliveryLocation != null ? this.deliveryLocation.getAddress() : null);
        dto.setItems(this.items != null
                ? this.items.stream().map(OrderItem::getDTO).collect(Collectors.toList())
                : new ArrayList<>());
        return dto;
    }
}