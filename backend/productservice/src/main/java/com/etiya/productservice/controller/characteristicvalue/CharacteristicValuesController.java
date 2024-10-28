package com.etiya.productservice.controller.characteristicvalue;


import com.etiya.productservice.dto.characteristicValue.request.CreateCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.DeleteCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.ListCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.UpdateCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.response.CreateCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.DeleteCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.ListCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.UpdateCharacteristicValueResponseDto;
import com.etiya.productservice.service.characteristicvalue.CharacteristicValueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characteristic-values")
@RequiredArgsConstructor
public class CharacteristicValuesController {

    private final CharacteristicValueService characteristicValueService;

    @PostMapping
    public ResponseEntity<CreateCharacteristicValueResponseDto> add(@RequestBody @Valid CreateCharacteristicValueRequestDto requestDto) {
        CreateCharacteristicValueResponseDto responseDto = characteristicValueService.add(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping
    public ResponseEntity<UpdateCharacteristicValueResponseDto> update(@RequestBody @Valid UpdateCharacteristicValueRequestDto requestDto) {
        UpdateCharacteristicValueResponseDto responseDto = characteristicValueService.update(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping
    public ResponseEntity<DeleteCharacteristicValueResponseDto> delete(@RequestBody @Valid DeleteCharacteristicValueRequestDto requestDto) {
        DeleteCharacteristicValueResponseDto responseDto = characteristicValueService.delete(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/getById")
    public ResponseEntity<ListCharacteristicValueResponseDto> getById(@RequestBody @Valid ListCharacteristicValueRequestDto requestDto) {
        ListCharacteristicValueResponseDto responseDto = characteristicValueService.getById(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<ListCharacteristicValueResponseDto>> getAll() {
        List<ListCharacteristicValueResponseDto> responseDtos = characteristicValueService.getAll();
        return ResponseEntity.ok(responseDtos);
    }

}