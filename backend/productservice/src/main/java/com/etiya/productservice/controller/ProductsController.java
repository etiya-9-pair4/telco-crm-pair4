package com.etiya.productservice.controller;

import com.etiya.productservice.dto.customer.CustomerResponseDto;
import com.etiya.productservice.dto.product.request.CreateProductRequestDto;
import com.etiya.productservice.dto.product.request.DeleteProductRequestDto;
import com.etiya.productservice.dto.product.request.ListProductRequestDto;
import com.etiya.productservice.dto.product.request.UpdateProductRequestDto;
import com.etiya.productservice.dto.product.response.CreateProductResponseDto;
import com.etiya.productservice.dto.product.response.DeleteProductResponseDto;
import com.etiya.productservice.dto.product.response.ListProductResponseDto;
import com.etiya.productservice.dto.product.response.UpdateProductResponseDto;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<CreateProductResponseDto> add(@RequestBody @Valid CreateProductRequestDto requestDto) {
        CreateProductResponseDto responseDto = productService.add(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping
    public ResponseEntity<UpdateProductResponseDto> update(@RequestBody @Valid UpdateProductRequestDto requestDto) {
        UpdateProductResponseDto responseDto = productService.update(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping
    public ResponseEntity<DeleteProductResponseDto> delete(@RequestBody @Valid DeleteProductRequestDto requestDto) {
        DeleteProductResponseDto responseDto = productService.delete(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/getById")
    public ResponseEntity<ListProductResponseDto> getById(@RequestBody @Valid ListProductRequestDto requestDto) {
        ListProductResponseDto responseDto = productService.getById(requestDto);
        if (responseDto != null) {
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public ResponseEntity<List<ListProductResponseDto>> getAll() {
        List<ListProductResponseDto> responseDtos = productService.getAll();
        return ResponseEntity.ok(responseDtos);
    }


    @PostMapping("search")
    public List<Product> getByIds(@RequestBody List<Integer> ids) {
        return productService.search(ids);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerResponseDto> getCustomerInfo(@PathVariable Integer customerId) {
        CustomerResponseDto customerInfo = productService.getCustomerInfo(customerId);
        if (customerInfo != null) {
            return ResponseEntity.ok(customerInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}