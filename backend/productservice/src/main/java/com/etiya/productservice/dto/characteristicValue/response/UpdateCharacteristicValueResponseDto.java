package com.etiya.productservice.dto.characteristicValue.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCharacteristicValueResponseDto {
    private Integer id;
    private String value;
    private Integer characteristicId;
}
