package com.etiya.productservice.dto.catalogProductOffer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCatalogProductOfferResponseDto {
    private Integer id;
    private Long productOfferId;
    private Long catalogId;
}
