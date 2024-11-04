package com.etiya.productservice.mapper.productOffer;

import com.etiya.productservice.dto.productoffer.request.CreateProductOfferRequestDto;
import com.etiya.productservice.dto.productoffer.request.DeleteProductOfferRequestDto;
import com.etiya.productservice.dto.productoffer.request.UpdateProductOfferRequestDto;
import com.etiya.productservice.dto.productoffer.response.*;
import com.etiya.productservice.entity.ProductOffer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductOfferMapper {

    // Create DTO'dan Entity'ye dönüşüm
    ProductOffer toProductOffer(CreateProductOfferRequestDto createDto);

    // Update DTO'dan Entity'ye dönüşüm
    ProductOffer toProductOffer(UpdateProductOfferRequestDto updateDto);

    // Delete DTO'dan Entity'ye dönüşüm
    ProductOffer toProductOffer(DeleteProductOfferRequestDto deleteDto);

    // Entity'den Create Response DTO'ya dönüşüm
    CreateProductOfferResponseDto toCreateProductOfferResponseDto(ProductOffer productOffer);

    // Entity'den Update Response DTO'ya dönüşüm
    UpdateProductOfferResponseDto toUpdateProductOfferResponseDto(ProductOffer productOffer);

    // Entity'den Delete Response DTO'ya dönüşüm
    DeleteProductOfferResponseDto toDeleteProductOfferResponseDto(ProductOffer productOffer);

    // Entity'den Response DTO'ya dönüşüm
    ProductOfferResponseDto toProductOfferResponseDto(ProductOffer productOffer);

    // Entity listesinden Response DTO listesine dönüşüm
    List<ProductOfferResponseDto> toProductOfferResponseDtoList(List<ProductOffer> productOffers);
}