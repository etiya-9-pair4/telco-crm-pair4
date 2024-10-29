package com.etiya.customerservice.dto.Address.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteAddressResponseDto {
    private Integer customerId;
    private Integer addressId;
    private String description;



}
