package com.etiya.productservice.dto.characteristic.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListCharacteristicRequestDto {
    @NotNull(message = "Characteristic ID cannot be null.")
    private Integer characteristicId;
}