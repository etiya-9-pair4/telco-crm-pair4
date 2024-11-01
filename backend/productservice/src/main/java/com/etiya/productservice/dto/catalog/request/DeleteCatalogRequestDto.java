package com.etiya.productservice.dto.catalog.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCatalogRequestDto {
    @NotNull(message = "ID cannot be null.")
    private Integer id;
}