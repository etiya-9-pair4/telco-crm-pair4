package com.etiya.productservice.service;

import com.etiya.productservice.client.CustomerServiceClient;
import com.etiya.productservice.dto.customer.CustomerResponseDto;
import com.etiya.productservice.dto.product.request.*;
import com.etiya.productservice.dto.product.response.*;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.mapper.ProductMapper;
import com.etiya.productservice.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CustomerServiceClient customerServiceClient;
    private final ProductMapper productMapper;


    @Override
    public CreateProductResponseDto add(CreateProductRequestDto requestDto) {
        Product product = productMapper.toEntity(requestDto);
        Product savedProduct = productRepository.save(product);

        return productMapper.toCreateProductResponseDto(savedProduct);
    }

    @Override
    public UpdateProductResponseDto update(UpdateProductRequestDto requestDto) {
        Product isExist = productRepository.findById(requestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + requestDto.getId()));

        Product product = productMapper.updateEntityFromDto(requestDto);
        Product updatedProduct = productRepository.save(product);
        return productMapper.toUpdateProductResponseDto(updatedProduct);
    }

    @Override
    public DeleteProductResponseDto delete(DeleteProductRequestDto requestDto) {
        Product product = productRepository.findById(requestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + requestDto.getId()));

        // Soft delete: deletedDate'yi güncelleyin
        product.onDelete(); // BaseEntity'den çağırabilirsiniz
        Product updatedProduct = productRepository.save(product); // Güncellenmiş ürünü kaydedin

        return productMapper.toDeleteProductResponseDto(updatedProduct);
    }

    @Override
    public ProductResponseDto getById(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
        return productMapper.toProductResponseDto(product);
    }


    @Override
    public FilterProductResponseDto filterProducts(FilterProductRequestDto requestDto) {
        return null;
    }

    @Override
    public List<ListProductResponseDto> getAll() {
        List<Product> products = productRepository.findAll();
        List<ListProductResponseDto> responseDtos = productMapper.toListProductResponseDtoList(products);
        return responseDtos;
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