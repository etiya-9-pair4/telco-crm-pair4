package com.etiya.productservice.service.catalog;

import com.etiya.productservice.dto.catalog.request.CreateCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.DeleteCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.ListCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.UpdateCatalogRequestDto;
import com.etiya.productservice.dto.catalog.response.CreateCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.DeleteCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.ListCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.UpdateCatalogResponseDto;

import java.util.List;

public interface CatalogService {
    CreateCatalogResponseDto add(CreateCatalogRequestDto requestDto);

    UpdateCatalogResponseDto update(UpdateCatalogRequestDto requestDto);

    DeleteCatalogResponseDto delete(DeleteCatalogRequestDto requestDto);

    ListCatalogResponseDto getById(ListCatalogRequestDto requestDto);

    List<ListCatalogResponseDto> getAll();
}
