package com.etiya.orderservice.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @NotNull
    @NotBlank
    private Integer id;

    @NotNull
    @NotBlank
    private LocalDateTime createdDate;

    @NotNull
    @NotBlank
    private LocalDateTime updatedDate;

    @NotNull
    @NotBlank
    private LocalDateTime deletedDate;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private BigDecimal price;

    @NotNull
    @NotBlank
    private Integer stock;

}
