package com.etiya.productservice.dto.productCharacteristicValue.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductCharacteristicValueRequestDto {
    @NotNull
    private Long productId;
    @NotNull
    private Long characteristicValueId;
}
