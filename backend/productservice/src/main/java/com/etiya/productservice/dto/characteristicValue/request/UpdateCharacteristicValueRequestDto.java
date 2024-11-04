package com.etiya.productservice.dto.characteristicValue.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCharacteristicValueRequestDto {
    @NotNull(message = "ID cannot be null.")
    private Integer id;

    @NotBlank(message = "Value cannot be empty.")
    private String value;

    @NotNull(message = "Characteristic ID cannot be null.")
    private Integer characteristicId;
}