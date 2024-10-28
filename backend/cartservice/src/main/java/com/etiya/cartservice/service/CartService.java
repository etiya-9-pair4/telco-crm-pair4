package com.etiya.cartservice.service;

import com.etiya.cartservice.dto.AddItemRequestDto;
import com.etiya.cartservice.entity.Cart;

import java.util.Map;

public interface CartService {



    void add(AddItemRequestDto addItemRequestDto);

    Map<String, Cart> getItems();

    Cart getCartByCustomerId(Long customerId);
}
