package com.etiya.productservice.mapper.characteristicvalue;

import com.etiya.productservice.dto.characteristicValue.request.CreateCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.DeleteCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.ListCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.request.UpdateCharacteristicValueRequestDto;
import com.etiya.productservice.dto.characteristicValue.response.CreateCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.DeleteCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.ListCharacteristicValueResponseDto;
import com.etiya.productservice.dto.characteristicValue.response.UpdateCharacteristicValueResponseDto;
import com.etiya.productservice.entity.CharacteristicValue;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CharacteristicValueMapper {

    // Create
    @Mapping(target = "characteristic.id", source = "characteristicId")
    CharacteristicValue toEntity(CreateCharacteristicValueRequestDto createDto);

    @Mapping(target = "characteristicId", source = "characteristic.id")
    CreateCharacteristicValueResponseDto toCreateResponseDto(CharacteristicValue characteristicValue);

    // Update

    @Mapping(target = "characteristic.id", source = "characteristicId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CharacteristicValue toEntity(UpdateCharacteristicValueRequestDto updateDto);

    @Mapping(target = "characteristicId", source = "characteristic.id")
    UpdateCharacteristicValueResponseDto toUpdateResponseDto(CharacteristicValue characteristicValue);

    // Delete
    CharacteristicValue toEntity(DeleteCharacteristicValueRequestDto deleteDto);

    @Mapping(target = "characteristicId", source = "characteristic.id")
    DeleteCharacteristicValueResponseDto toDeleteResponseDto(CharacteristicValue characteristicValue);

    // List
    CharacteristicValue toEntity(ListCharacteristicValueRequestDto listDto);

    @Mapping(target = "characteristicId", source = "characteristic.id")
    ListCharacteristicValueResponseDto toListResponseDto(CharacteristicValue characteristicValue);

    List<ListCharacteristicValueResponseDto> toListResponseDtoList(List<CharacteristicValue> characteristicValues);
}
