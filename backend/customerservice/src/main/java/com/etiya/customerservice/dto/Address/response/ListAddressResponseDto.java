package com.etiya.customerservice.dto.Address.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListAddressResponseDto {
    private Integer addressId;
    private Integer customerId;
    private String description;
    private Integer districtId;
    private String street;
    private String houseNumber;
    private boolean isDefault;
}
