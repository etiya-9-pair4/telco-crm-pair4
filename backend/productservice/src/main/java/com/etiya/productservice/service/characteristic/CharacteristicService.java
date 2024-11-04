package com.etiya.productservice.service.characteristic;

import com.etiya.productservice.dto.characteristic.request.CreateCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.DeleteCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.ListCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.UpdateCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.response.CreateCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.DeleteCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.ListCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.UpdateCharacteristicResponseDto;

import java.util.List;

public interface CharacteristicService {
    CreateCharacteristicResponseDto add(CreateCharacteristicRequestDto requestDto);

    UpdateCharacteristicResponseDto update(UpdateCharacteristicRequestDto requestDto);

    DeleteCharacteristicResponseDto delete(DeleteCharacteristicRequestDto requestDto);

    ListCharacteristicResponseDto getById(ListCharacteristicRequestDto requestDto);

    List<ListCharacteristicResponseDto> getAll();
}
