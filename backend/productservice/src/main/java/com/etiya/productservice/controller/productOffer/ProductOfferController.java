package com.etiya.productservice.controller.productOffer;

import com.etiya.productservice.dto.productoffer.request.CreateProductOfferRequestDto;
import com.etiya.productservice.dto.productoffer.request.UpdateProductOfferRequestDto;
import com.etiya.productservice.dto.productoffer.response.CreateProductOfferResponseDto;
import com.etiya.productservice.dto.productoffer.response.DeleteProductOfferResponseDto;
import com.etiya.productservice.dto.productoffer.response.ListProductOffersResponseDto;
import com.etiya.productservice.dto.productoffer.response.ProductOfferResponseDto;
import com.etiya.productservice.service.productOffer.ProductOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-offers")
@RequiredArgsConstructor
public class ProductOfferController {

    private final ProductOfferService productOfferService;

    @PostMapping
    public ResponseEntity<CreateProductOfferResponseDto> createProductOffer(@RequestBody CreateProductOfferRequestDto createDto) {
        CreateProductOfferResponseDto response = productOfferService.createProductOffer(createDto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOfferResponseDto> updateProductOffer(@PathVariable Integer id, @RequestBody UpdateProductOfferRequestDto updateDto) {
        updateDto.setId(id); // UpdateDto'ya ID set ediyoruz
        ProductOfferResponseDto response = productOfferService.updateProductOffer(updateDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteProductOfferResponseDto> deleteProductOffer(@PathVariable Integer id) {
        DeleteProductOfferResponseDto response = productOfferService.deleteProductOffer(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOfferResponseDto> getById(@PathVariable Integer id) {
        ProductOfferResponseDto response = productOfferService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ListProductOffersResponseDto> getAll() {
        List<ProductOfferResponseDto> productOfferList = productOfferService.getAll().getProductOffers();
        ListProductOffersResponseDto response = new ListProductOffersResponseDto(productOfferList);
        return ResponseEntity.ok(response);
    }
}
