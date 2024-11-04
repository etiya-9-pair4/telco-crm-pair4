package com.etiya.productservice.dto.productoffer.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProductOfferRequestDto {
    private Integer id; // silinmek istenen ProductOffer'ın id'si
}