package com.etiya.productservice.mapper;

import com.etiya.productservice.dto.product.request.*;
import com.etiya.productservice.dto.product.response.*;
import com.etiya.productservice.entity.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    // Create
    @Mapping(target = "catalog.id", source = "catalogId")
    @Mapping(target = "productCharacteristicValues", expression = "java(mapCharacteristicValues(createProductRequestDto.getCharacteristicValueIds(), product))")
    Product toEntity(CreateProductRequestDto createProductRequestDto);

    @Mapping(target = "catalogId", source = "catalog.id")
    CreateProductResponseDto toCreateProductResponseDto(Product product);

    // Delete
    Product toEntity(DeleteProductRequestDto deleteProductRequestDto);

    DeleteProductResponseDto toDeleteProductResponseDto(Product product);

    // Update
    @Mapping(target = "catalog.id", source = "catalogId")
    @Mapping(target = "productCharacteristicValues", expression = "java(mapCharacteristicValues(updateProductRequestDto.getCharacteristicValueIds(), product))")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product toEntity(UpdateProductRequestDto updateProductRequestDto);

    @Mapping(target = "catalogId", source = "catalog.id")
    UpdateProductResponseDto toUpdateProductResponseDto(Product product);

    // Filter Product
    @Mapping(target = "catalog.id", source = "catalogId")
    @Mapping(target = "productCharacteristicValues", expression = "java(mapCharacteristicValues(filterProductRequestDto.getCharacteristicValueIds(), product))")
    @Mapping(target = "campaignProducts", expression = "java(mapCampaigns(filterProductRequestDto.getCampaignIds(), product))")
    Product toEntity(FilterProductRequestDto filterProductRequestDto);

    // List Product
    @Mapping(target = "id", source = "productId")
    Product toEntity(ListProductRequestDto listProductRequestDto);

    @Mapping(target = "catalogId", source = "catalog.id")
    @Mapping(target = "characteristicValueIds", expression = "java(mapCharacteristicValueIds(product))")
    @Mapping(target = "campaignIds", expression = "java(mapCampaignIds(product))")
    ProductResponseDto toProductResponseDto(Product product);

    List<ProductResponseDto> toProductResponseDtoList(List<Product> products);


    ListProductResponseDto toListProductResponseDto(Product product);

    List<ListProductResponseDto> toListProductResponseDtoList(List<Product> products);


    // Default methods for transforming characteristics and campaigns
    default List<Integer> mapCharacteristicValueIds(Product product) {
        return product.getProductCharacteristicValues().stream()
                .map(pcv -> pcv.getCharacteristicValue().getId())
                .toList();
    }

    default List<Integer> mapCampaignIds(Product product) {
        return product.getCampaignProducts().stream()
                .map(cp -> cp.getCampaign().getId())
                .toList();
    }

    default List<ProductCharacteristicValue> mapCharacteristicValues(List<Integer> ids, Product product) {
        if (ids == null) return null;
        return ids.stream().map(id -> {
            ProductCharacteristicValue pcv = new ProductCharacteristicValue();
            pcv.setCharacteristicValue(new CharacteristicValue(id));
            pcv.setProduct(product);
            return pcv;
        }).toList();
    }

    default List<CampaignProduct> mapCampaigns(List<Integer> ids, Product product) {
        if (ids == null) return null;
        return ids.stream().map(id -> {
            CampaignProduct cp = new CampaignProduct();
            cp.setCampaign(new Campaign(id));
            cp.setProduct(product);
            return cp;
        }).toList();
    }
}