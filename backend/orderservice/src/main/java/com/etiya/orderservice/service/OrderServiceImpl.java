package com.etiya.orderservice.service;

import com.etiya.orderservice.client.ProductServiceClient;
import com.etiya.orderservice.dto.product.ProductDto;
import com.etiya.orderservice.dto.request.CreateOrderRequestDto;
import com.etiya.orderservice.entity.Order;
import com.etiya.orderservice.repository.OrderRepository;
import io.github.macidko.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
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
        order.setCustomerId(createOrderRequestDto.getCustomerId());
        order.setProducts(response);
        orderRepository.save(order);

        kafkaTemplate.send("orderTopic", new OrderCreatedEvent(order.getId()));

    }
}
