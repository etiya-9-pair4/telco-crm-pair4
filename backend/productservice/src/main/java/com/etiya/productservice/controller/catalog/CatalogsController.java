package com.etiya.productservice.controller.catalog;

import com.etiya.productservice.dto.catalog.request.CreateCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.DeleteCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.ListCatalogRequestDto;
import com.etiya.productservice.dto.catalog.request.UpdateCatalogRequestDto;
import com.etiya.productservice.dto.catalog.response.CreateCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.DeleteCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.ListCatalogResponseDto;
import com.etiya.productservice.dto.catalog.response.UpdateCatalogResponseDto;
import com.etiya.productservice.service.catalog.CatalogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogs")
@RequiredArgsConstructor
public class CatalogsController {

    private final CatalogService catalogService;

    @PostMapping
    public ResponseEntity<CreateCatalogResponseDto> add(@RequestBody @Valid CreateCatalogRequestDto requestDto) {
        CreateCatalogResponseDto responseDto = catalogService.add(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping
    public ResponseEntity<UpdateCatalogResponseDto> update(@RequestBody @Valid UpdateCatalogRequestDto requestDto) {
        UpdateCatalogResponseDto responseDto = catalogService.update(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping
    public ResponseEntity<DeleteCatalogResponseDto> delete(@RequestBody @Valid DeleteCatalogRequestDto requestDto) {
        DeleteCatalogResponseDto responseDto = catalogService.delete(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/getById")
    public ResponseEntity<ListCatalogResponseDto> getById(@RequestBody @Valid ListCatalogRequestDto requestDto) {
        ListCatalogResponseDto responseDto = catalogService.getById(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<ListCatalogResponseDto>> getAll() {
        List<ListCatalogResponseDto> responseDtos = catalogService.getAll();
        return ResponseEntity.ok(responseDtos);
    }
}