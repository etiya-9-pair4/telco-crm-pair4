package com.etiya.productservice.dto.characteristic.request;


import com.etiya.productservice.entity.CharacteristicValue;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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
public class CreateCharacteristicRequestDto {

    @NotBlank(message = "Product name cannot be empty.")
    private String name;

    @NotNull(message = "Description cannot be null.")
    @Column(name="description")
    private String description;


}
