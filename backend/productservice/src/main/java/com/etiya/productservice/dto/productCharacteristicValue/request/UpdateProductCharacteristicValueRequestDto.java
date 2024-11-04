package com.etiya.productservice.dto.productCharacteristicValue.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductCharacteristicValueRequestDto {
    private Integer id;
    private Long productId;
    private Long characteristicValueId;
}