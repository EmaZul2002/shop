package com.corso.shop.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corso.shop.models.Product;
import com.corso.shop.services.interfaces.ProductService;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService ProductService;
    
    public ProductController(ProductService ProductService) {
        this.ProductService = ProductService;
    }

    @GetMapping("")
    public List<Product> getAll() {
        return ProductService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        System.out.println(id);
        return ProductService.findById(id).orElse(null);
    }

    @PostMapping("")
    public Product save(@PathVariable Product product) {
        return ProductService.save(product);
    }
    
    @PostMapping("category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return ProductService.findByCategory(category);
    }

    @PostMapping("avaiability/{id}/{avaiability}")
    public void changeAvaiability(@PathVariable String id, @PathVariable Number avaiability) {
        ProductService.changeAvaiability(id, avaiability);
    }
}