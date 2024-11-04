package com.etiya.productservice.service.characteristicValue;

import com.etiya.productservice.dto.characteristicValue.request.CreateCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.DeleteCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.ListCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.UpdateCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.response.CreateCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.DeleteCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.ListCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.UpdateCharacteristicValueResponseDto;

import java.util.List;

public interface CharacteristicValueService {
    CreateCharacteristicValueResponseDto add(CreateCharacteristicValueRequestDto requestDto);

    UpdateCharacteristicValueResponseDto update(UpdateCharacteristicValueRequestDto requestDto);

    DeleteCharacteristicValueResponseDto delete(DeleteCharacteristicValueRequestDto requestDto);

    ListCharacteristicValueResponseDto getById(ListCharacteristicValueRequestDto requestDto);

    List<ListCharacteristicValueResponseDto> getAll();
}