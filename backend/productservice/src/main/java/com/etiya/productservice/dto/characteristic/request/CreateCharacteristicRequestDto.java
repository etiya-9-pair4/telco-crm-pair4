package com.etiya.productservice.dto.characteristic.request;

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
public class CreateCharacteristicRequestDto {

    @NotBlank(message = "Product name cannot be empty.")
    private String name;

    @NotNull(message = "Description cannot be null.")
    @Column(name = "description")
    private String description;
}