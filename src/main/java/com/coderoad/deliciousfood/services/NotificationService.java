package com.coderoad.deliciousfood.services;

import com.coderoad.deliciousfood.models.Order;
import com.coderoad.deliciousfood.models.Restaurant;
import org.springframework.stereotype.Service;

/**
 * Service class for handling notifications related to restaurants and orders.
 */
@Service
public class NotificationService {

    /**
     * Sends a notification to a restaurant.
     *
     * @param restaurant the restaurant to notify
     * @param message    the message content to be sent
     */
    public void notifyToRestaurant(Restaurant restaurant, String message) {
        // In a real-world app, implement push notification, SMS, or email here.
        System.out.println("Notifying restaurant: " + restaurant.getName() + " with message: " + message);
    }

    /**
     * Sends a notification when an order is ready.
     *
     * @param order   the order that is ready
     * @param message the message content to be sent
     */
    public void notifyOrderReady(Order order, String message) {
        // In a real-world app, implement push notification, SMS, or email here.
        System.out.println("Notifying order: " + order.getItems() + " with message: " + message);
    }
}