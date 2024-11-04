package com.etiya.productservice.dto.characteristicValue.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCharacteristicValueRequestDto {
    @NotNull(message = "ID cannot be null.")
    private Integer id;
}