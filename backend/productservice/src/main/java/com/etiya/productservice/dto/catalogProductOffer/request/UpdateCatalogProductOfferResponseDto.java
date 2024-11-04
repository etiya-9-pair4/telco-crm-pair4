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
public class UpdateCatalogProductOfferResponseDto {
    @NotNull
    private Integer id;
    @NotNull
    private Long productOfferId;
    @NotNull
    private Long catalogId;
}