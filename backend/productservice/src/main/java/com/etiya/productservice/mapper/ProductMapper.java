package com.etiya.productservice.mapper;

import com.etiya.productservice.dto.request.CreateProductRequestDto;
import com.etiya.productservice.dto.request.DeleteProductRequestDto;
import com.etiya.productservice.dto.request.UpdateProductRequestDto;
import com.etiya.productservice.dto.response.CreateProductResponseDto;
import com.etiya.productservice.dto.response.DeleteProductResponseDto;
import com.etiya.productservice.dto.response.ListProductResponseDto;
import com.etiya.productservice.dto.response.UpdateProductResponseDto;
import com.etiya.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductMapper {

    public abstract Product productFromCreateDto(CreateProductRequestDto createProductRequestDto);

    public abstract CreateProductResponseDto productToCreateResponseDto(Product product);

//    @Mapping(target = "name", source = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(target = "price", source = "price", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(target = "stock", source = "stock", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(target = "catalog", source = "catalog", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(target = "campaignProducts", source = "campaignProducts", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  //  @Mapping(target = "productCharacteristicValues", source = "productCharacteristicValues", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    public abstract Product productFromUpdateDto(UpdateProductRequestDto updateProductRequestDto);
//
//    public abstract UpdateProductResponseDto productToUpdateResponseDto(Product product);
//
//    public abstract Product productFromDeleteDto(DeleteProductRequestDto deleteProductRequestDto);
//
//    public abstract DeleteProductResponseDto productToDeleteResponseDto(Product product);
//
//
//    public abstract ListProductResponseDto productListToListProductResponseDto(Product product);
//
//    public abstract List<ListProductResponseDto> productsToResponseDtoList(List<Product> products);

}
