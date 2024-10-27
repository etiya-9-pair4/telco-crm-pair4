package com.etiya.productservice.service;

import com.etiya.productservice.dto.customer.CustomerResponseDto;
import com.etiya.productservice.dto.product.request.CreateProductRequestDto;
import com.etiya.productservice.dto.product.request.DeleteProductRequestDto;
import com.etiya.productservice.dto.product.request.UpdateProductRequestDto;
import com.etiya.productservice.dto.product.response.CreateProductResponseDto;
import com.etiya.productservice.dto.product.response.DeleteProductResponseDto;
import com.etiya.productservice.dto.product.response.ListProductResponseDto;
import com.etiya.productservice.dto.product.response.UpdateProductResponseDto;
import com.etiya.productservice.entity.Product;

import java.util.List;


public interface ProductService {

    //ListProductResponseDto getById(Integer id);

    List<ListProductResponseDto> getAll();

    //List<ListProductResponseDto> getByName(String name);

    DeleteProductResponseDto delete(DeleteProductRequestDto deleteProductRequestDto);

    CreateProductResponseDto add(CreateProductRequestDto createProductRequestDto);

    UpdateProductResponseDto update(UpdateProductRequestDto updateProductRequestDto);

    List<Product> search(List<Integer> ids);
    CustomerResponseDto getCustomerInfo(Integer customerId);
}
