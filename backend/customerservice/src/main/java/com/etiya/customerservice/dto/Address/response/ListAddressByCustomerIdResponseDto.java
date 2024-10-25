package com.etiya.customerservice.dto.Address.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListAddressByCustomerIdResponseDto {
    private Integer customerId;
    private String street;
    private String houseNumber;
    private String description;
    private boolean isDefault;
    private Integer districtId;
}
