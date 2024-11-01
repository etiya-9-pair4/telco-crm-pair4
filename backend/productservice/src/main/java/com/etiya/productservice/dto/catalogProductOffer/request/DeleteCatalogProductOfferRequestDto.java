package com.etiya.productservice.dto.catalogProductOffer.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCatalogProductOfferRequestDto {
    @NotNull
    private Integer id;
}
