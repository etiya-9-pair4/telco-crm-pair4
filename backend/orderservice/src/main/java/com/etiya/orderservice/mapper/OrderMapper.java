package com.etiya.orderservice.mapper;

import com.etiya.orderservice.dto.request.UpdateOrderRequestDto;
import com.etiya.orderservice.dto.response.CreateOrderResponseDto;
import com.etiya.orderservice.dto.response.DeleteOrderResponseDto;
import com.etiya.orderservice.dto.response.UpdateOrderResponseDto;
import com.etiya.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class OrderMapper {

    @Mapping(target="products", source = "products")
    public abstract Order OrderFromUpdateRequest(UpdateOrderRequestDto updateOrderRequestDto);

    @Mapping(target="products", source = "products")
    public abstract UpdateOrderResponseDto orderUpdateResponseFromOrder(Order order);

    @Mapping(target="products", source = "products")
    public abstract CreateOrderResponseDto orderCreateResponseFromOrder(Order order);

    @Mapping(target="products", source = "products")
    public abstract DeleteOrderResponseDto orderDeleteResponseFromOrder(Order order);


}
