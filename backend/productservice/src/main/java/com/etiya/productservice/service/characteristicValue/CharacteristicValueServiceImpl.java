package com.etiya.productservice.service.characteristicValue;

import com.etiya.productservice.dto.characteristicValue.request.CreateCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.DeleteCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.ListCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.UpdateCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.response.CreateCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.DeleteCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.ListCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.UpdateCharacteristicValueResponseDto;
import com.etiya.productservice.entity.CharacteristicValue;
import com.etiya.productservice.mapper.characteristicValue.CharacteristicValueMapper;
import com.etiya.productservice.repository.characteristicValue.CharacteristicValueRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacteristicValueServiceImpl implements CharacteristicValueService {
    private final CharacteristicValueRepository characteristicValueRepository;
    private final CharacteristicValueMapper characteristicValueMapper;

    @Override
    @Transactional
    public CreateCharacteristicValueResponseDto add(CreateCharacteristicValueRequestDto requestDto) {
        CharacteristicValue characteristicValue = characteristicValueMapper.toEntity(requestDto);
        characteristicValue = characteristicValueRepository.save(characteristicValue);

        return characteristicValueMapper.toCreateResponseDto(characteristicValue);
    }

    @Override
    @Transactional
    public UpdateCharacteristicValueResponseDto update(UpdateCharacteristicValueRequestDto requestDto) {
        CharacteristicValue characteristicValue = characteristicValueMapper.toEntity(requestDto);
        characteristicValue = characteristicValueRepository.save(characteristicValue);

        return characteristicValueMapper.toUpdateResponseDto(characteristicValue);
    }

    @Override
    @Transactional
    public DeleteCharacteristicValueResponseDto delete(DeleteCharacteristicValueRequestDto requestDto) {
        CharacteristicValue isExist = characteristicValueRepository.findById(requestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Characteristic not found with id: " + requestDto.getId()));

        CharacteristicValue characteristicValue = characteristicValueMapper.toEntity(requestDto);
        characteristicValueRepository.delete(characteristicValue);

        return characteristicValueMapper.toDeleteResponseDto(characteristicValue);
    }

    @Override
    @Transactional
    public ListCharacteristicValueResponseDto getById(ListCharacteristicValueRequestDto requestDto) {
        CharacteristicValue characteristicValue = characteristicValueRepository.findById(requestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Characteristic Value not found with id: " + requestDto.getId()));
        ListCharacteristicValueResponseDto responseDto = characteristicValueMapper.toListResponseDto(characteristicValue);
        return responseDto;
    }

    @Override
    @Transactional
    public List<ListCharacteristicValueResponseDto> getAll() {
        List<CharacteristicValue> characteristicValues = characteristicValueRepository.findAll();
        List<ListCharacteristicValueResponseDto> responseDtos = characteristicValueMapper.toListResponseDtoList(characteristicValues);
        return responseDtos;
    }
}