package com.etiya.orderservice.controller;

import com.etiya.orderservice.dto.request.CreateOrderRequestDto;
import com.etiya.orderservice.dto.request.UpdateOrderRequestDto;
import com.etiya.orderservice.dto.response.CreateOrderResponseDto;
import com.etiya.orderservice.dto.response.DeleteOrderResponseDto;
import com.etiya.orderservice.dto.response.UpdateOrderResponseDto;
import com.etiya.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    //TODO: Convert all to dto

    @GetMapping()
    public ResponseEntity<List<CreateOrderResponseDto>> getAll() {

        return ResponseEntity.ok(orderService.getAll());

    }

    @GetMapping("/{orderId}")
    public ResponseEntity<CreateOrderResponseDto> getById(String orderId) {

        return ResponseEntity.ok(orderService.getOrderById(orderId));

    }

    @PostMapping()
    public ResponseEntity add(@RequestBody CreateOrderRequestDto orderRequestDto) {
        orderService.add(orderRequestDto);
        return ResponseEntity.ok("Eklendi");
    }

    @PutMapping()
    public ResponseEntity<UpdateOrderResponseDto> updateOrder(@RequestBody @Valid UpdateOrderRequestDto updateOrderRequestDto) {
        //updateOrderRequestDto.setOrderId(updateOrderRequestDto.getOrderId()); // ID'yi ayarlayın
        UpdateOrderResponseDto responseDto = orderService.update(updateOrderRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<DeleteOrderResponseDto> deleteCustomer(String orderId) {
        DeleteOrderResponseDto responseDto = orderService.delete(orderId);
        return ResponseEntity.ok(responseDto);
    }
}
