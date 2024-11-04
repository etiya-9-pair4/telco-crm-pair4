package com.etiya.productservice.mapper.characteristic;

import com.etiya.productservice.dto.characteristic.request.CreateCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.DeleteCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.ListCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.request.UpdateCharacteristicRequestDto;
import com.etiya.productservice.dto.characteristic.response.CreateCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.DeleteCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.ListCharacteristicResponseDto;
import com.etiya.productservice.dto.characteristic.response.UpdateCharacteristicResponseDto;
import com.etiya.productservice.entity.Characteristic;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CharacteristicMapper {

    // Create
    Characteristic toEntity(CreateCharacteristicRequestDto createCharacteristicRequestDto);

    CreateCharacteristicResponseDto toCreateCharacteristicResponseDto(Characteristic characteristic);

    // Update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Characteristic toEntity(UpdateCharacteristicRequestDto updateCharacteristicRequestDto);

    UpdateCharacteristicResponseDto toUpdateResponseDto(Characteristic characteristic);

    // Delete
    Characteristic toEntity(DeleteCharacteristicRequestDto deleteCharacteristicRequestDto);

    DeleteCharacteristicResponseDto toDeleteResponseDto(Characteristic characteristic);

    // List
    @Mapping(target = "id", source = "characteristicId")
    Characteristic toEntity(ListCharacteristicRequestDto listCharacteristicRequestDto);

    ListCharacteristicResponseDto toListResponseDto(Characteristic characteristic);

    List<ListCharacteristicResponseDto> toListResponseDtoList(List<Characteristic> characteristics);


}