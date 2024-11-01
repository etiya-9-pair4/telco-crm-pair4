package com.etiya.cartservice.service;

import com.etiya.cartservice.dto.AddItemRequestDto;
import com.etiya.cartservice.entity.Cart;
import com.etiya.cartservice.entity.CartItem;
import com.etiya.cartservice.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final RedisRepository redisRepository;
//    private final CustomerServiceClient customerServiceClient;
//    private final CatalogServiceClient catalogServiceClient;


    @Override
    public void add(AddItemRequestDto addItemRequestDto) {

        Cart cart = redisRepository.getCartByCustomerId(addItemRequestDto.getCustomerId());
        if (cart==null){
            cart= new Cart();
            cart.setCustomerId(addItemRequestDto.getCustomerId());
        }

        // todo : setleri düzelt

        //GetCustomerResponse response = customerServiceClient.getById(customerId);
//        GetProductResponse productResponse = catalogServiceClient.getById(addItemRequestDto.getProductId());
//        CartItem cartItem = new CartItem();
//        cartItem.setProductId(addItemRequestDto.getProductId());
//        cartItem.setPrice(productResponse.getPrice());
//        cartItem.setProductName(productResponse.getName());
//        cartItem.setQuantity(addItemRequestDto.getQuantity());
//        cart.setCustomerId(addItemRequestDto.getCustomerId());
//        cartItem.setTotalItemAmount(cartItem.getQuantity() * cartItem.getPrice());
//        cart.getCartItemList().add(cartItem);
//        cart.setTotalAmount(cart.getCartItemList().stream()
//                .mapToDouble(item -> item.getTotalItemAmount())
//                .sum());



        redisRepository.addItem(cart);
    }

    @Override
    public Map<String, Cart> getItems() {
        return redisRepository.getAllItems();
    }

    @Override
    public Cart getCartByCustomerId(Long customerId) {
        return redisRepository.getCartByCustomerId(customerId);
    }
}