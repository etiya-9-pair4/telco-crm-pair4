package com.etiya.productservice.dto.characteristic.request;


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
public class UpdateCharacteristicRequestDto {
    @NotNull(message = "ID cannot be null.")
    private Integer id;

    @NotBlank(message = "Characteristic name cannot be empty.")
    private String name;

    @NotNull(message = "Description cannot be null.")
    private String description;
}
