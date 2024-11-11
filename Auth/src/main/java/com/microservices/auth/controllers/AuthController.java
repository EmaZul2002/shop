package com.microservices.catalog.controllers;

import com.microservices.catalog.models.JwtResponse;
import com.microservices.catalog.services.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api/products")
public class AuthController {

    //List products: /products
    //Get product by Id: /products/{id}
    //Search by category: /products/category/{category}
    //Create product: POST /products
    //Change availability: PUT /products/{id}/availability/{value}

    private final ProductService productService;

    public AuthController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<JwtResponse> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Optional<JwtResponse> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/category/{category}")
    public List<JwtResponse> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/code/{code}")
    public Optional<JwtResponse> getProductByCode(@PathVariable String code) {
        return productService.getProductByCode(code);
    }

    @PostMapping("")
    public JwtResponse createProduct(@RequestBody JwtResponse product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}/availability/{value}")
    public JwtResponse updateAvailability(@PathVariable String id,
                                      @PathVariable Integer value) {
        return productService.updateAvailability(id, value);
    }

}
