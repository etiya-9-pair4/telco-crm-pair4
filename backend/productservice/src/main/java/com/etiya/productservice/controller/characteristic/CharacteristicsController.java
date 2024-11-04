package com.etiya.productservice.controller.characteristic;

import com.etiya.productservice.dto.characteristic.request.CreateCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.DeleteCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.ListCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.UpdateCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.response.CreateCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.DeleteCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.ListCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.UpdateCharacteristicResponseDto;
import com.etiya.productservice.dto.product.request.CreateProductRequestDto;
import com.etiya.productservice.dto.product.request.DeleteProductRequestDto;
import com.etiya.productservice.dto.product.request.ListProductRequestDto;
import com.etiya.productservice.dto.product.request.UpdateProductRequestDto;
import com.etiya.productservice.dto.product.response.CreateProductResponseDto;
import com.etiya.productservice.dto.product.response.DeleteProductResponseDto;
import com.etiya.productservice.dto.product.response.ListProductResponseDto;
import com.etiya.productservice.dto.product.response.UpdateProductResponseDto;
import com.etiya.productservice.service.characteristic.CharacteristicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characteristics")
@RequiredArgsConstructor
public class CharacteristicsController {
    private final CharacteristicService characteristicService;

    @PostMapping
    public ResponseEntity<CreateCharacteristicResponseDto> add(@RequestBody @Valid CreateCharacteristicRequestDto requestDto) {
        CreateCharacteristicResponseDto responseDto = characteristicService.add(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping
    public ResponseEntity<UpdateCharacteristicResponseDto> update(@RequestBody @Valid UpdateCharacteristicRequestDto requestDto) {
        UpdateCharacteristicResponseDto responseDto = characteristicService.update(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping
    public ResponseEntity<DeleteCharacteristicResponseDto> delete(@RequestBody @Valid DeleteCharacteristicRequestDto requestDto) {
        DeleteCharacteristicResponseDto responseDto = characteristicService.delete(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/getById")
    public ResponseEntity<ListCharacteristicResponseDto> getById(@RequestBody @Valid ListCharacteristicRequestDto requestDto) {
        ListCharacteristicResponseDto responseDto = characteristicService.getById(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<ListCharacteristicResponseDto>> getAll() {
        List<ListCharacteristicResponseDto> responseDtos = characteristicService.getAll();
        return ResponseEntity.ok(responseDtos);
    }

}