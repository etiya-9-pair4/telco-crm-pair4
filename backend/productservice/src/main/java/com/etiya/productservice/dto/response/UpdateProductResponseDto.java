package com.etiya.productservice.dto.response;

import com.etiya.productservice.entity.CampaignProduct;
import com.etiya.productservice.entity.Catalog;
import com.etiya.productservice.entity.ProductCharacteristicValue;
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
public class UpdateProductResponseDto {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private Catalog catalog;
    private List<ProductCharacteristicValue> productCharacteristicValues;
    private List<CampaignProduct> campaignProducts;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
}
