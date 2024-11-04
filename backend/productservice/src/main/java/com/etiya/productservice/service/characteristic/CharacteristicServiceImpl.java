package com.etiya.productservice.service.characteristic;

import com.etiya.productservice.dto.characteristic.request.CreateCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.DeleteCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.ListCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.UpdateCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.response.CreateCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.DeleteCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.ListCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.UpdateCharacteristicResponseDto;
import com.etiya.productservice.entity.Characteristic;
import com.etiya.productservice.mapper.characteristic.CharacteristicMapper;
import com.etiya.productservice.repository.characteristic.CharacteristicRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacteristicServiceImpl implements CharacteristicService {
    private final CharacteristicRepository characteristicRepository;
    private final CharacteristicMapper characteristicMapper;

    @Override
    public CreateCharacteristicResponseDto add(CreateCharacteristicRequestDto requestDto) {
        Characteristic characteristic = characteristicMapper.toEntity(requestDto);
        Characteristic savedCharacteristic = characteristicRepository.save(characteristic);

        return characteristicMapper.toCreateCharacteristicResponseDto(savedCharacteristic);
    }

    @Override
    public UpdateCharacteristicResponseDto update(UpdateCharacteristicRequestDto requestDto) {
        Characteristic isExist = characteristicRepository.findById(requestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Characteristic not found with id: " + requestDto.getId()));

        Characteristic characteristic = characteristicMapper.toEntity(requestDto);
        Characteristic updatedCharacteristic = characteristicRepository.save(characteristic);

        return characteristicMapper.toUpdateResponseDto(updatedCharacteristic);

    }

    @Override
    public DeleteCharacteristicResponseDto delete(DeleteCharacteristicRequestDto requestDto) {
        Characteristic characteristic = characteristicRepository.findById(requestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Characteristic not found with id: " + requestDto.getId()));
        characteristicRepository.delete(characteristic);
        return characteristicMapper.toDeleteResponseDto(characteristic);

    }

    @Override
    public ListCharacteristicResponseDto getById(ListCharacteristicRequestDto requestDto) {
        Characteristic characteristic = characteristicRepository.findById(requestDto.getCharacteristicId())
                .orElseThrow(() -> new EntityNotFoundException("Characteristic not found with id: " + requestDto.getCharacteristicId()));
        ListCharacteristicResponseDto responseDto = characteristicMapper.toListResponseDto(characteristic);
        return responseDto;
    }

    @Override
    public List<ListCharacteristicResponseDto> getAll() {
        List<Characteristic> characteristics = characteristicRepository.findAll();
        List<ListCharacteristicResponseDto> responseDtos = characteristicMapper.toListResponseDtoList(characteristics);
        return responseDtos;
    }
}