package com.coderoad.deliciousfood.controllers;

import com.coderoad.deliciousfood.DTOs.OrderDTO;
import com.coderoad.deliciousfood.models.Order;
import com.coderoad.deliciousfood.models.OrderStatus;
import com.coderoad.deliciousfood.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderService.createOrder(orderDTO);
        return order.getDTO();
    }

    @GetMapping("/{orderId}")
    public OrderDTO getOrder(@PathVariable Long orderId) {
        return orderService.getById(orderId)
                .map(Order::getDTO)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @PutMapping("/{orderId}/status")
    public OrderDTO updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        Order order = orderService.updateStatus(orderId, status);
        return order.getDTO();
    }
}
