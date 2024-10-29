package com.etiya.customerservice.dto.CustomerAccount.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerAccountResponseDto {
    private Integer id;
    private Integer customerId;
    private Integer addressId;
    private Integer typeId;
    private String accountNumber;
    private String accountName;
    private boolean status;
}
