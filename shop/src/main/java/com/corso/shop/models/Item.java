package com.corso.shop.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Item {
    private String productId;
    private String productTitle;
    private String productCategory;
    private Integer quantity;
    private Long price;
}
