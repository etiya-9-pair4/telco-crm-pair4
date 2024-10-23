package com.etiya.orderservice.dto.response;

import com.etiya.orderservice.dto.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListOrderResponseDto {
    private List<ProductDto> products;
    private Integer customerId;
    private float totalPrice;
    private LocalDate createdDate;

}
