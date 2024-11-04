package com.etiya.productservice.dto.product.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProductRequestDto {

    @NotNull(message = "Product ID cannot be null.")
    private Integer id;
}