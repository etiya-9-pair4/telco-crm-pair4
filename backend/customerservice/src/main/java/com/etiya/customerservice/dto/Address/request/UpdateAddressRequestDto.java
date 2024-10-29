package com.etiya.customerservice.dto.Address.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequestDto {
    @NotNull
    private Integer addressId;
    private String description;
    @NotNull
    private Integer customerId;
    @NotNull
    private Integer districtId;
    private String street;
    private String houseNumber;
    @NotNull
    private boolean isDefault;

}
