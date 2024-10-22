package com.etiya.orderservice.controller;

import com.etiya.orderservice.dto.request.CreateOrderRequestDto;
import com.etiya.orderservice.entity.Order;
import com.etiya.orderservice.service.OrderService;
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
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody CreateOrderRequestDto orderRequestDto) {
        orderService.add(orderRequestDto);
        return ResponseEntity.ok("Eklendi");
    }
}
