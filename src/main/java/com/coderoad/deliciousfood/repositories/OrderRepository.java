package com.coderoad.deliciousfood.repositories;

import com.coderoad.deliciousfood.models.Order;
import com.coderoad.deliciousfood.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
    List<Order> findByDeliveryManId(Long deliveryManId);
    List<Order> findByStatus(OrderStatus status);
}