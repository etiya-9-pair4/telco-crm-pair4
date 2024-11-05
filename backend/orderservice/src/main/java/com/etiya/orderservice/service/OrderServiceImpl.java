package com.etiya.orderservice.service;

import com.etiya.orderservice.client.ProductServiceClient;
import com.etiya.orderservice.dto.request.CreateOrderRequestDto;
import com.etiya.orderservice.dto.request.UpdateOrderRequestDto;
import com.etiya.orderservice.dto.response.CreateOrderResponseDto;
import com.etiya.orderservice.dto.response.DeleteOrderResponseDto;
import com.etiya.orderservice.dto.product.ProductDto;
import com.etiya.orderservice.dto.response.UpdateOrderResponseDto;
import com.etiya.orderservice.entity.Order;
import com.etiya.orderservice.mapper.OrderMapper;
import com.etiya.orderservice.repository.OrderRepository;
import io.github.macidko.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class  OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final OrderMapper orderMapper;

    @Override
    public List<CreateOrderResponseDto> getAll() {

        return orderRepository.findAll().stream().map(orderMapper::orderCreateResponseFromOrder).collect(Collectors.toList());
    }

    @Override
    public void add(CreateOrderRequestDto createOrderRequestDto) {

        // Customer bilgileri

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
        Order order = new Order();
        order.setCreatedDate(LocalDate.now());
        order.setProducts(response);
        orderRepository.save(order);

        kafkaTemplate.send("orderTopic", new OrderCreatedEvent(order.getId()));

    }

    @Transactional
    @Override
    public UpdateOrderResponseDto update(UpdateOrderRequestDto updateOrderRequestDto) {

        Order updatedOrder = orderMapper.OrderFromUpdateRequest(updateOrderRequestDto);

        orderRepository.save(updatedOrder);

        return orderMapper.orderUpdateResponseFromOrder(updatedOrder);

    }

    @Transactional
    @Override
    public CreateOrderResponseDto getOrderById(String orderId) {

        Order order = orderRepository.getOrderById(orderId);

        CreateOrderResponseDto orderResponseDto = orderMapper.orderCreateResponseFromOrder(order);

        return orderResponseDto;
    }

    @Transactional
    @Override
    public DeleteOrderResponseDto delete(String orderId) {

        return orderMapper.orderDeleteResponseFromOrder(orderRepository.deleteOrderById(orderId));
    }
}
