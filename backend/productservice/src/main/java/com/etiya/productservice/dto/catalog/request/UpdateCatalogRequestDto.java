package com.etiya.productservice.dto.catalog.request;


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
public class UpdateCatalogRequestDto {
    @NotNull(message = "Catalog ID cannot be null.")
    private Integer id;
    @NotBlank(message = "Catalog name cannot be empty.")
    private String name;
    private Integer parentId;
}
