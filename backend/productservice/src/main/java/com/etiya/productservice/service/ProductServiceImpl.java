package com.etiya.productservice.service;

import com.etiya.productservice.client.CustomerServiceClient;
import com.etiya.productservice.dto.customer.CustomerResponseDto;
import com.etiya.productservice.dto.product.request.CreateProductRequestDto;
import com.etiya.productservice.dto.product.request.DeleteProductRequestDto;
import com.etiya.productservice.dto.product.request.UpdateProductRequestDto;
import com.etiya.productservice.dto.product.response.CreateProductResponseDto;
import com.etiya.productservice.dto.product.response.DeleteProductResponseDto;
import com.etiya.productservice.dto.product.response.ListProductResponseDto;
import com.etiya.productservice.dto.product.response.UpdateProductResponseDto;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CustomerServiceClient customerServiceClient;


    //TODO: MapStruct
    @Override
    public List<ListProductResponseDto> getAll() {
        return null;
    }

    @Override
    public DeleteProductResponseDto delete(DeleteProductRequestDto deleteProductRequestDto) {
        return null;
    }

    @Override
    public CreateProductResponseDto add(CreateProductRequestDto createProductRequestDto) {
        return null;
    }

    @Override
    public UpdateProductResponseDto update(UpdateProductRequestDto updateProductRequestDto) {
        return null;
    }

    @Override
    public List<Product> search(List<Integer> ids) {
        return productRepository.findByIdIn(ids);
    }

    @Override
    public CustomerResponseDto getCustomerInfo(Integer customerId) {
        return customerServiceClient.getCustomerById(customerId);
    }
}
