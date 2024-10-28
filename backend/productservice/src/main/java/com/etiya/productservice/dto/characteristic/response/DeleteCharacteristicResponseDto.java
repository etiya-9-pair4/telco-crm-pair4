package com.etiya.productservice.dto.characteristic.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCharacteristicResponseDto {
    private Integer id;
    private String name;
    private LocalDateTime deletedDate;
}