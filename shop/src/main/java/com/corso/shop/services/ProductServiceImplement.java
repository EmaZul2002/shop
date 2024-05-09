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

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public void changeAvaiability(String id, Number avaiability) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setAvailability(avaiability);
            productRepository.save(product);
        }
    }

    public Boolean isAvailable(String id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return product.getAvailability() != null && product.getAvailability().intValue() > 0;
        }
        return false;
    }
}
