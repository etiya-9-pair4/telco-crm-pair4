package com.etiya.orderservice.mapper;

import com.etiya.orderservice.dto.request.CreateOrderRequestDto;
import com.etiya.orderservice.dto.response.CreateOrderResponseDto;
import com.etiya.orderservice.dto.response.ListOrderResponseDto;
import com.etiya.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class OrderMapper {

//    @Mapping(target="products", source = "products")
//    public abstract Order OrderFromUpdateRequest(UpdateOrderRequestDto updateOrderRequestDto);

//    @Mapping(target="products", source = "products")
//    public abstract UpdateOrderResponseDto orderUpdateResponseFromOrder(Order order);

    public abstract Order orderCreateRequestFromDto(CreateOrderRequestDto createOrderRequestDto);
    public abstract List<ListOrderResponseDto> getAllOrdersResponseDtoFromOrders(List<Order> order);

    public abstract ListOrderResponseDto getOrdersResponseDtoFromOrders(Order order);
    public abstract CreateOrderResponseDto orderCreateResponseFromOrder(Order order);




}
