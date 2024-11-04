package com.etiya.productservice.dto.catalogProductOffer.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCatalogProductOfferResponseDto {
    private Integer id;
    private Long productOfferId;
    private Long catalogId;
}
