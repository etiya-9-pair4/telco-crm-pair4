package com.etiya.productservice.dto.characteristicValue.request;


import jakarta.persistence.Column;
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
public class CreateCharacteristicValueRequestDto {

    @NotBlank(message = "Characteristic value cannot be empty.")
    private String value;

    @NotNull(message = "Characteristic ID cannot be null.")
    private Integer characteristicId;


}
