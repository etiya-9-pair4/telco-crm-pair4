package com.etiya.productservice.dto.product.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResponseDto {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private Integer catalogId;
    private LocalDateTime createdDate;
}