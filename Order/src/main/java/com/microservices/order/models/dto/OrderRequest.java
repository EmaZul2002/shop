package com.microservices.order.models.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private String productId;
    private Integer quantity;
}
