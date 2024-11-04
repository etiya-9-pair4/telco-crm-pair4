package com.etiya.productservice.dto.catalogProductOffer.request;

import com.etiya.productservice.entity.Catalog;
import com.etiya.productservice.entity.ProductOffer;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCatalogProductOfferRequestDto {
    @NotNull
    private Long productOfferId;
    @NotNull
    private Long catalogId;
}