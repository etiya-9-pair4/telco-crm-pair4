package com.etiya.customerservice.dto.Address.response;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressResponseDto {
    private Integer addressId;
    private Integer customerId;
    private String street;
    private String houseNumber;
    private String description;
    private boolean isDefault;
    private Integer districtId;
}
