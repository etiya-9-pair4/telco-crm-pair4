package com.etiya.cartservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CartItem implements Serializable {

    private String id;
    private UUID productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Double totalItemAmount;

    public CartItem()
    {
        this.id = UUID.randomUUID().toString();
    }
}
