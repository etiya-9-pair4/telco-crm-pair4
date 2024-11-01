package com.etiya.productservice.service;

import com.etiya.productservice.dto.customer.CustomerResponseDto;
import com.etiya.productservice.dto.product.request.*;
import com.etiya.productservice.dto.product.response.*;
import com.etiya.productservice.entity.Product;

import java.util.List;


public interface ProductService {


    CreateProductResponseDto add(CreateProductRequestDto requestDto);

    UpdateProductResponseDto update(UpdateProductRequestDto requestDto);

    DeleteProductResponseDto delete(DeleteProductRequestDto requestDto);

    ListProductResponseDto getById(ListProductRequestDto requestDto);

    FilterProductResponseDto filterProducts(FilterProductRequestDto requestDto);

    List<ListProductResponseDto> getAll();


    List<Product> search(List<Integer> ids);

    CustomerResponseDto getCustomerInfo(Integer customerId);
}
