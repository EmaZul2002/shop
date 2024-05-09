package com.corso.shop.services.interfaces;

import java.util.List;

import com.corso.shop.models.Item;

public interface CartService {

    void addItem(String userId, String productId, int quantity);

    void deleteItem(String userId, String productId);
    
    void clearCart(String userId);

    Long getTotalPrice(String userId);

    List<Item> getItems(String userId);
}
