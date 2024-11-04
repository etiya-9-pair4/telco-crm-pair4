package com.etiya.productservice.dto.characteristic.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCharacteristicResponseDto {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime updatedDate;
}
