package com.microservices.order.controllers;

import com.microservices.order.models.Order;
import com.microservices.order.models.dto.OrderRequest;
import com.microservices.order.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/user")
    public ResponseEntity<List<Order>> getUserOrders(@AuthenticationPrincipal UserDetails userDetails) {
        String userId = userDetails.getUsername();
        List<Order> orders = orderService.getUserPurchases(userId);
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Optional<Order>> createOrder(@RequestBody OrderRequest orderRequest,
                                                       @AuthenticationPrincipal UserDetails userDetails) {
        String userId = userDetails.getUsername();
        Optional<Order> order = orderService.buy(userId, orderRequest.getQuantity(), orderRequest.getProductId());
        return ResponseEntity.ok(order);
    }

    @GetMapping("/paperino")
    public String getMethodName() {
        return new String("Sono io paperino");
    }
    
}
