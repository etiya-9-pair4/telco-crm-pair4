package com.etiya.productservice.dto.productCharacteristicValue.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProductCharacteristicValueResponseDto {
    private Integer id;
    private Long productId;
    private Long characteristicValueId;
}