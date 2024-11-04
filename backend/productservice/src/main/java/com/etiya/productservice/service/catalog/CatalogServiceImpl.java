package com.etiya.productservice.service.catalog;

import com.etiya.productservice.dto.catalog.request.CreateCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.DeleteCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.ListCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.UpdateCatalogRequestDto;
import com.etiya.productservice.dto.catalog.response.CreateCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.DeleteCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.ListCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.UpdateCatalogResponseDto;
import com.etiya.productservice.entity.Catalog;
import com.etiya.productservice.mapper.catalog.CatalogMapper;
import com.etiya.productservice.repository.catalog.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;
    private final CatalogMapper catalogMapper;

    @Override
    @Transactional
    public CreateCatalogResponseDto add(CreateCatalogRequestDto requestDto) {
        System.out.println("Adding catalog with Parent ID: " + requestDto.getParentId());


        Catalog catalog = catalogMapper.toEntity(requestDto);

        if (requestDto.getParentId() == null) {
            catalog.setParent(null);
        } else {
            // Parent ID varsa, parent catalog bulunur
            Catalog parentCatalog = catalogRepository.findById(requestDto.getParentId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent catalog not found"));
            catalog.setParent(parentCatalog);
        }

        catalog = catalogRepository.save(catalog);
        return catalogMapper.toCreateCatalogResponseDto(catalog);
    }

    @Override
    @Transactional
    public UpdateCatalogResponseDto update(UpdateCatalogRequestDto requestDto) {
        Catalog existingCatalog = catalogRepository.findById(requestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Catalog not found"));

        Catalog catalog = catalogMapper.toEntity(requestDto);
        catalog.setId(existingCatalog.getId());

        if (requestDto.getParentId() != null) {
            Catalog parentCatalog = catalogRepository.findById(requestDto.getParentId())
                    .orElseThrow(() -> new IllegalArgumentException("Parent catalog not found"));
            catalog.setParent(parentCatalog);
        } else {
            catalog.setParent(null);
        }

        catalog = catalogRepository.save(catalog);
        return catalogMapper.toUpdateCatalogResponseDto(catalog);
    }

    @Override
    @Transactional
    public DeleteCatalogResponseDto delete(DeleteCatalogRequestDto requestDto) {
        Catalog catalog = catalogRepository.findById(requestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Catalog not found"));
        catalogRepository.delete(catalog);
        return catalogMapper.toDeleteCatalogResponseDto(catalog);
    }

    @Override
    @Transactional
    public ListCatalogResponseDto getById(ListCatalogRequestDto requestDto) {
        Catalog catalog = catalogRepository.findById(requestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Catalog not found"));
        return catalogMapper.toListCatalogResponseDto(catalog);
    }

    @Override
    @Transactional
    public List<ListCatalogResponseDto> getAll() {
        List<Catalog> catalogs = catalogRepository.findAll();
        return catalogMapper.toListCatalogResponseDtoList(catalogs);
    }
}