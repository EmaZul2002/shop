package com.corso.shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.corso.shop.models.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
    
}
