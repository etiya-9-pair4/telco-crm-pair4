package com.etiya.productservice.dto.request;

import com.etiya.productservice.entity.CampaignProduct;
import com.etiya.productservice.entity.Catalog;
import com.etiya.productservice.entity.ProductCharacteristicValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDto {

    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @PositiveOrZero
    private BigDecimal price;
    @NotBlank
    @PositiveOrZero
    private Integer stock;
    @NotNull
    @NotBlank
    private Catalog catalog;
    @NotBlank
    private List<CampaignProduct> campaignProducts;
//    @NotNull
//    @NotBlank
//    private List<ProductCharacteristicValue> productCharacteristicValues;

}
