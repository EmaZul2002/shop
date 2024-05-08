package com.corso.shop.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.corso.shop.models.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
    
}
