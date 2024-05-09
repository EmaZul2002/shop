package com.corso.shop.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.corso.shop.models.Cart;
import com.corso.shop.models.Item;
import com.corso.shop.repository.CartRepository;
import com.corso.shop.repository.ProductRepository;

public class CartServiceImplement {
    private final CartRepository cartRepository;

    public CartServiceImplement(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addItem(String userId, String productId, int quantity) {
        if (cartRepository.findById(productId).isPresent()) {
            cartRepository.findById(productId).get().setQuantity(cartRepository.findById(productId).get().getQuantity() + quantity);
        }
    }

    public void deleteItem(String userId, String productId) {
        
    }
}
