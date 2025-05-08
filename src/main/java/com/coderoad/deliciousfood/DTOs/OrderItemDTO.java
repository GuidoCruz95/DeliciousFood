package com.coderoad.deliciousfood.DTOs;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long foodItemId;
    private Integer quantity;
}