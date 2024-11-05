package com.etiya.orderservice.service;

import com.etiya.orderservice.dto.request.CreateOrderRequestDto;
import com.etiya.orderservice.dto.request.UpdateOrderRequestDto;
import com.etiya.orderservice.dto.response.CreateOrderResponseDto;
import com.etiya.orderservice.dto.response.DeleteOrderResponseDto;
import com.etiya.orderservice.dto.response.UpdateOrderResponseDto;

import java.util.List;

public interface OrderService {
    List<CreateOrderResponseDto> getAll();

    void add(CreateOrderRequestDto createOrderRequestDto);

    UpdateOrderResponseDto update(UpdateOrderRequestDto updateOrderRequestDto);
    CreateOrderResponseDto getOrderById(String orderId);

    DeleteOrderResponseDto delete(String orderId);
}
