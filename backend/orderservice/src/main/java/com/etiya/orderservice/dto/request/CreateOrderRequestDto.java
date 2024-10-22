package com.etiya.orderservice.dto.request;

import com.etiya.orderservice.dto.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequestDto {
    private Integer customerId;
    private List<ProductDto> products;
}