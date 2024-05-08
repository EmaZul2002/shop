package com.corso.shop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.corso.shop.models.Product;
import com.corso.shop.repository.ProductRepository;
import com.corso.shop.services.interfaces.ProductService;
@Service
public class ProductServiceImplement implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImplement(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
}
