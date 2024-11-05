package com.etiya.orderservice.service;

import com.etiya.orderservice.dto.request.CreateOrderRequestDto;

import com.etiya.orderservice.dto.response.CreateOrderResponseDto;
import com.etiya.orderservice.dto.response.ListOrderResponseDto;

import java.util.List;

public interface OrderService {
    List<CreateOrderResponseDto> getAll();

    CreateOrderResponseDto add(CreateOrderRequestDto createOrderRequestDto);


//    UpdateOrderResponseDto update(UpdateOrderRequestDto updateOrderRequestDto);
    ListOrderResponseDto getById(String orderId);

}
