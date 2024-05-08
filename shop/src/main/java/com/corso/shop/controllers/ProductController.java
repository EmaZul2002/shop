package com.corso.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corso.shop.services.interfaces.ProductService;

public class ProductController {
    
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
