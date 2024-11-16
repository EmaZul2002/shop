package com.microservices.order.services.interfaces;

import com.microservices.order.models.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getUserPurchases(String userId);
    Optional<Order> buy(String userId, int quantity, String productId);
}
