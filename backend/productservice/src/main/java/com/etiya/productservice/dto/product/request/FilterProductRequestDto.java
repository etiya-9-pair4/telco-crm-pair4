package com.etiya.productservice.dto.product.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterProductRequestDto {
    private String name;
    @Min(value = 0, message = "Minimum price cannot be negative.")
    private BigDecimal minPrice;
    @Min(value = 0, message = "Maximum price cannot be negative.")
    private BigDecimal maxPrice;
    private Integer catalogId;
    private Integer stock;
    private List<Integer> characteristicValueIds;
    private List<Integer> campaignIds;

}