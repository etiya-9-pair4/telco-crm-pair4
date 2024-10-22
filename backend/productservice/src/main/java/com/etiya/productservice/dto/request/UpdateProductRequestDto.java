package com.etiya.productservice.dto.request;

import com.etiya.productservice.entity.CampaignProduct;
import com.etiya.productservice.entity.Catalog;
import com.etiya.productservice.entity.ProductCharacteristicValue;
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
public class UpdateProductRequestDto {
    @NotNull
    private Integer id;

    private String name;

    @PositiveOrZero
    private BigDecimal price;

    @PositiveOrZero
    private Integer stock;

    private Catalog catalog;

    private List<CampaignProduct> campaignProducts;

//    private List<ProductCharacteristicValue> productCharacteristicValues;

}
