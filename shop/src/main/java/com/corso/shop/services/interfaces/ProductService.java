package com.corso.shop.services.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.corso.shop.models.Product;

@Service
public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(String id);

    Product save(Product product);
    
    List<Product> findByCategory(String category);

    void changeAvaiability(String id, Number avaiability);
}
