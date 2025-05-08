package com.coderoad.deliciousfood.DTOs;


import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Long userId;
    private Long restaurantId;
    private List<OrderItemDTO> items;
    private String deliveryAddress;
}