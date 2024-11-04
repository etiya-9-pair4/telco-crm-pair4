package com.etiya.productservice.mapper.catalog;

import com.etiya.productservice.dto.catalog.request.CreateCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.DeleteCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.ListCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.UpdateCatalogRequestDto;
import com.etiya.productservice.dto.catalog.response.CreateCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.DeleteCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.ListCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.UpdateCatalogResponseDto;
import com.etiya.productservice.entity.Catalog;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogMapper {

    // Create
    @Mapping(target = "parent.id", source = "parentId")
    @Mapping(target = "parent", ignore = true)
    Catalog toEntity(CreateCatalogRequestDto createCatalogRequestDto);

    @Mapping(target = "parentId", source = "parent.id")
    @Mapping(target = "parentName", source = "parent.name")
    CreateCatalogResponseDto toCreateCatalogResponseDto(Catalog catalog);

    // Update
    @Mapping(target = "parent.id", source = "parentId")
    @Mapping(target = "parent", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Catalog toEntity(UpdateCatalogRequestDto updateCatalogRequestDto);

    @Mapping(target = "parentId", source = "parent.id")
    UpdateCatalogResponseDto toUpdateCatalogResponseDto(Catalog catalog);

    // Delete
    Catalog toEntity(DeleteCatalogRequestDto deleteCatalogRequestDto);

    DeleteCatalogResponseDto toDeleteCatalogResponseDto(Catalog catalog);

    // List
    Catalog toEntity(ListCatalogRequestDto listCatalogRequestDto);

    @Mapping(target = "parentId", source = "parent.id")
    ListCatalogResponseDto toListCatalogResponseDto(Catalog catalog);

    @Mapping(target = "parentId", source = "parent.id")
    List<ListCatalogResponseDto> toListCatalogResponseDtoList(List<Catalog> catalog);
}
