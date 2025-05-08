package com.coderoad.deliciousfood.services;

import com.coderoad.deliciousfood.DTOs.OrderDTO;
import com.coderoad.deliciousfood.models.Order;
import com.coderoad.deliciousfood.models.OrderStatus;
import com.coderoad.deliciousfood.models.Restaurant;
import com.coderoad.deliciousfood.models.User;
import com.coderoad.deliciousfood.repositories.DeliveryManRepository;
import com.coderoad.deliciousfood.repositories.OrderRepository;
import com.coderoad.deliciousfood.repositories.RestaurantRepository;
import com.coderoad.deliciousfood.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Service class for managing orders, including creation, retrieval, status updates,
 * and notifying restaurants and users.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final NotificationService notificationService;

    /**
     * Constructs the OrderService with the required repositories and services.
     *
     * @param orderRepository       the repository for Order entities
     * @param userRepository        the repository for User entities
     * @param restaurantRepository  the repository for Restaurant entities
     * @param deliveryManRepository (Unused currently) the repository for DeliveryMan entities
     * @param notificationService   the service to send notifications
     */
    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        RestaurantRepository restaurantRepository,
                        DeliveryManRepository deliveryManRepository,
                        NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.notificationService = notificationService;
    }

    /**
     * Creates a new order from the given DTO, sets the initial status, and notifies the restaurant.
     *
     * @param orderDto the DTO containing order data
     * @return the created and saved Order entity
     * @throws RuntimeException if the user or restaurant is not found
     */
    public Order createOrder(OrderDTO orderDto) {
        User orderUser = userRepository.findById(orderDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Restaurant restaurant = restaurantRepository.findById(orderDto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Order order = Order.builder()
                .user(orderUser)
                .restaurant(restaurant)
                .orderTime(LocalDateTime.now()) // Note: Improve using timezone awareness
                .status(OrderStatus.ORDERED)
                .build();

        notifyRestaurantOfNewOrder(order);
        return orderRepository.save(order);
    }

    /**
     * Retrieves an Order by its ID.
     *
     * @param id the ID of the order
     * @return an Optional containing the Order if found
     */
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    /**
     * Updates the status of an order and sends a notification if the order is ready to ship.
     *
     * @param orderId the ID of the order
     * @param status  the new status to apply
     * @return the updated Order entity
     * @throws RuntimeException if the order is not found
     */
    public Order updateStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);

        if (status.equals(OrderStatus.READY_TO_SHIP)) {
            String msg = "New Order Ready to ship";
            notificationService.notifyOrderReady(order, msg);
        }

        return orderRepository.save(order);
    }

    /**
     * Sends a notification to the restaurant about a new order.
     *
     * @param order the new order to notify about
     */
    private void notifyRestaurantOfNewOrder(Order order) {
        String message = "New order received! Details: " + order.toString(); // Consider overriding toString
        notificationService.notifyToRestaurant(order.getRestaurant(), message);
    }
}
