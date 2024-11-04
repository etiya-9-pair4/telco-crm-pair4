package com.etiya.productservice.dto.productoffer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListProductOffersResponseDto {
    private List<ProductOfferResponseDto> productOffers;
}