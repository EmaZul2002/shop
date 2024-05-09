package com.corso.shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.corso.shop.models.Cart;

public interface CartRepository extends MongoRepository<Cart, String> {

}
