package com.etiya.productservice.dto.catalog.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCatalogResponseDto {
    private Integer id;
    private String name;
    private Integer parentId;
    private String parentName;
    private LocalDateTime updatedDate;
}