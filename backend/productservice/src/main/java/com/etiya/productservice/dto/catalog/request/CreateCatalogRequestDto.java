package com.etiya.productservice.dto.catalog.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCatalogRequestDto {

    @NotBlank(message = "Catalog name cannot be empty.")
    private String name;
    private Integer parentId;
}