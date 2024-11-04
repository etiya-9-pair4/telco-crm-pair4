package com.etiya.productservice.dto.product.request;


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
public class CreateProductRequestDto {

    @NotBlank(message = "Product name cannot be empty.")
    private String name;

    @NotNull(message = "Price cannot be null.")
    @PositiveOrZero(message = "Price must be zero or positive.")
    private BigDecimal price;

    @NotNull(message = "Stock cannot be null.")
    @PositiveOrZero(message = "Stock must be zero or positive.")
    private Integer stock;

    @NotNull(message = "Catalog ID cannot be null.")
    private Integer catalogId;

    @NotNull(message = "Characteristic Value IDs cannot be null.")
    @Size(min = 1, message = "At least one Characteristic Value ID must be provided.")
    private List<Integer> characteristicValueIds; // Product ile CharacteristicValue ilişkisi için
    private List<Integer> campaignIds; // Product ile CharacteristicValue ilişkisi için

}