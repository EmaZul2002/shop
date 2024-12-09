package com.microservices.catalog.controllers;

import com.microservices.catalog.models.Product;
import com.microservices.catalog.services.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    //List products: /products
    //Get product by Id: /products/{id}
    //Search by category: /products/category/{category}
    //Create product: POST /products
    //Change availability: PUT /products/{id}/availability/{value}

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/code/{code}")
    public Optional<Product> getProductByCode(@PathVariable String code) {
        return productService.getProductByCode(code);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}/availability/{value}")
    public Product updateAvailability(@PathVariable String id,
                                      @PathVariable Integer value) {
        return productService.updateAvailability(id, value);
    }

    @GetMapping("/paperino")
    public String getMethodName() {
        return new String("Sono io paperino");
    }
}
