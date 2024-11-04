package com.etiya.productservice.service.productoffer;

import com.etiya.productservice.dto.productoffer.request.CreateProductOfferRequestDto;
import com.etiya.productservice.dto.productoffer.request.UpdateProductOfferRequestDto;
import com.etiya.productservice.dto.productoffer.response.CreateProductOfferResponseDto;
import com.etiya.productservice.dto.productoffer.response.DeleteProductOfferResponseDto;
import com.etiya.productservice.dto.productoffer.response.ProductOfferResponseDto;
import com.etiya.productservice.dto.productoffer.response.ListProductOffersResponseDto;
import com.etiya.productservice.entity.ProductOffer;
import com.etiya.productservice.mapper.productoffer.ProductOfferMapper;
import com.etiya.productservice.repository.productoffer.ProductOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOfferServiceImpl implements ProductOfferService {
    private final ProductOfferRepository productOfferRepository;
    private final ProductOfferMapper productOfferMapper;

    @Override
    @Transactional
    public CreateProductOfferResponseDto createProductOffer(CreateProductOfferRequestDto createDto) {
        ProductOffer productOffer = productOfferMapper.toProductOffer(createDto);
        ProductOffer savedProductOffer = productOfferRepository.save(productOffer);
        return productOfferMapper.toCreateProductOfferResponseDto(savedProductOffer);
    }

    @Override
    @Transactional
    public ProductOfferResponseDto updateProductOffer(UpdateProductOfferRequestDto updateDto) {
        ProductOffer productOffer = productOfferRepository.findById(updateDto.getId())
                .orElseThrow(() -> new RuntimeException("ProductOffer not found with ID: " + updateDto.getId()));
        // Mapping update data onto the existing entity
        productOfferMapper.toProductOffer(updateDto); // Existing data is modified as per the updateDto
        ProductOffer updatedProductOffer = productOfferRepository.save(productOffer);
        return productOfferMapper.toProductOfferResponseDto(updatedProductOffer);
    }

    @Override
    @Transactional
    public DeleteProductOfferResponseDto deleteProductOffer(Integer id) {
        ProductOffer productOffer = productOfferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductOffer not found with ID: " + id));
        productOfferRepository.delete(productOffer);
        return productOfferMapper.toDeleteProductOfferResponseDto(productOffer);
    }

    @Override
    public ProductOfferResponseDto getById(Integer id) {
        ProductOffer productOffer = productOfferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductOffer not found with ID: " + id));
        return productOfferMapper.toProductOfferResponseDto(productOffer);
    }

    @Override
    public ListProductOffersResponseDto getAll() {
        List<ProductOffer> productOffers = productOfferRepository.findAll();
        List<ProductOfferResponseDto> productOfferDtos = productOfferMapper.toProductOfferResponseDtoList(productOffers);
        return new ListProductOffersResponseDto(productOfferDtos);
    }
}
