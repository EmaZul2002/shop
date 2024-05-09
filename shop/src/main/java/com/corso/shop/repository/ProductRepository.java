package com.corso.shop.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.corso.shop.models.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

    public List<Product> findByCategory(String category);
}
