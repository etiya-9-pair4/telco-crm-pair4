package com.etiya.productservice.service.productOffer;

import com.etiya.productservice.dto.productoffer.request.CreateProductOfferRequestDto;
import com.etiya.productservice.dto.productoffer.request.UpdateProductOfferRequestDto;
import com.etiya.productservice.dto.productoffer.response.CreateProductOfferResponseDto;
import com.etiya.productservice.dto.productoffer.response.DeleteProductOfferResponseDto;
import com.etiya.productservice.dto.productoffer.response.ListProductOffersResponseDto;
import com.etiya.productservice.dto.productoffer.response.ProductOfferResponseDto;

public interface ProductOfferService {
    CreateProductOfferResponseDto createProductOffer(CreateProductOfferRequestDto createDto);
    ProductOfferResponseDto updateProductOffer(UpdateProductOfferRequestDto updateDto);
    DeleteProductOfferResponseDto deleteProductOffer(Integer id);
    ProductOfferResponseDto getById(Integer id);
    ListProductOffersResponseDto getAll();
}
