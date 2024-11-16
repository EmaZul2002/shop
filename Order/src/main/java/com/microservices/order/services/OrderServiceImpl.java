package com.microservices.order.services;

import com.microservices.order.models.Order;
import com.microservices.order.models.dto.OrderRequest;
import com.microservices.order.repositories.OrderRepository;
import com.microservices.order.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getUserPurchases(String userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Optional<Order> buy(String userId, int quantity, String productId) {
        Order newOrder = new Order(null, productId, "Sample Product", "Category", quantity, 100.0, userId);
        return Optional.of(orderRepository.save(newOrder));
    }
}
