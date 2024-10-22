package com.etiya.productservice.service;

import com.etiya.productservice.dto.request.CreateProductRequestDto;
import com.etiya.productservice.dto.request.DeleteProductRequestDto;
import com.etiya.productservice.dto.request.UpdateProductRequestDto;
import com.etiya.productservice.dto.response.CreateProductResponseDto;
import com.etiya.productservice.dto.response.DeleteProductResponseDto;
import com.etiya.productservice.dto.response.ListProductResponseDto;
import com.etiya.productservice.dto.response.UpdateProductResponseDto;
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
}
