package com.etiya.productservice.dto.request;

import jakarta.validation.constraints.NotBlank;
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
public class CreateProductRequestDto {
    @NotBlank
    @NotNull
    private String name;
    @PositiveOrZero
    private BigDecimal price;
    @PositiveOrZero
    private Integer stock;
    @NotNull
    private Integer catalogId;
    @NotNull
    private List<Integer> campaignProductIds;

    @NotNull
    private List<Integer> productCharacteristicValueIds;
}
