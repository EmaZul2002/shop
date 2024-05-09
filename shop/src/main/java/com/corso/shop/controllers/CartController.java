package com.corso.shop.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.corso.shop.models.Item;
import com.corso.shop.services.interfaces.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public List<Item> getItems(@PathVariable String userId) {
        return cartService.getItems(userId);
    }

    @PostMapping("/{userId}/product/{productId}/quantity/{quantity}")
    public void addItem(String userId, String productId, int quantity) {
        cartService.addItem(userId, productId, quantity);
    }

    @DeleteMapping("/{userId}/product/{productId}")
    public void deleteItem(String userId, String productId) {
        cartService.deleteItem(userId, productId);
    }
}
