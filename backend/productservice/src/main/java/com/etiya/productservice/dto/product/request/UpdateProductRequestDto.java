package com.etiya.productservice.dto.product.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequestDto {
    @NotNull(message = "Product ID cannot be null.")
    private Integer id;
    private String name;
    @PositiveOrZero(message = "Price must be zero or positive.")
    private BigDecimal price;
    @PositiveOrZero(message = "Stock must be zero or positive.")
    private Integer stock;
    @NotNull(message = "Catalog ID cannot be null.")
    private Integer catalogId;
    private List<Integer> characteristicValueIds;
    private List<Integer> campaignIds;
}