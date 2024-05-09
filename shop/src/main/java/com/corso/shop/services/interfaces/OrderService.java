package com.corso.shop.services.interfaces;

import java.util.*;

import com.corso.shop.models.Order;

public interface OrderService {
    Optional<Order> save(Order order);

    List<Order> findAll();

    Optional<Order> findById(String id);

    void deleteById(String id);
}
