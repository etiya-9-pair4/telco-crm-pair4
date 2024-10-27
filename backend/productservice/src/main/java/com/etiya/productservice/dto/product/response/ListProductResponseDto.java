package com.etiya.productservice.dto.product.response;

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
public class ListProductResponseDto {
    private ProductResponseDto product;
}
