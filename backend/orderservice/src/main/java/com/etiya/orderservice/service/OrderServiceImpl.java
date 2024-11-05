package com.etiya.orderservice.service;

import com.etiya.orderservice.client.ProductServiceClient;
import com.etiya.orderservice.dto.request.CreateOrderRequestDto;
import com.etiya.orderservice.dto.response.CreateOrderResponseDto;
import com.etiya.orderservice.dto.product.ProductDto;
import com.etiya.orderservice.dto.response.ListOrderResponseDto;
import com.etiya.orderservice.entity.Order;
import com.etiya.orderservice.mapper.OrderMapper;
import com.etiya.orderservice.repository.OrderRepository;
import io.github.macidko.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;
    private final StreamBridge streamBridge;
    private final OrderMapper orderMapper;

    @Override
    public List<CreateOrderResponseDto> getAll() {

        return orderRepository.findAll().stream().map(orderMapper::orderCreateResponseFromOrder).collect(Collectors.toList());
    }

    @Override
    public CreateOrderResponseDto add(CreateOrderRequestDto createOrderRequestDto) {

        // Customer bilgileri
        Order order = orderMapper.orderCreateRequestFromDto(createOrderRequestDto);


        List<ProductDto> response = productServiceClient.findAllByIds(
                createOrderRequestDto.getProducts().stream().map(ProductDto::getId).toList()
        );

        //TODO: Refactor as business rules.
        // OrderBusinessRules.AllProductsShouldExist()
        if (response.size() != createOrderRequestDto.getProducts().size()) //
        {
            // Ürün sayısı uyuşmuyor..
        }

        // 293 -> 5 adet istenmiş stok yeterli mi?
        order.setCreatedDate(LocalDate.now());
        orderRepository.save(order);

        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
        orderCreatedEvent.setId(order.getId());
        streamBridge.send("orderCreatedEvent-out-0", orderCreatedEvent);
        return orderMapper.orderCreateResponseFromOrder(order);

    }

//    @Transactional
//    @Override
//    public UpdateOrderResponseDto update(UpdateOrderRequestDto updateOrderRequestDto) {
//
//        Order updatedOrder = orderMapper.OrderFromUpdateRequest(updateOrderRequestDto);
//
//        orderRepository.save(updatedOrder);
//
//        return orderMapper.orderUpdateResponseFromOrder(updatedOrder);
//
//    }

    @Transactional
    @Override
    public ListOrderResponseDto getById(String orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow();

        ListOrderResponseDto listOrderResponseDto = orderMapper.getOrdersResponseDtoFromOrders(order);

        return listOrderResponseDto;
    }


}
