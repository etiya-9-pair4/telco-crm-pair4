package com.etiya.customerservice.dto.CustomerAccount.response;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerAccountResponseDto {
    private Integer customerId;
    private Integer addressId;
    private Integer typeId;
    private String accountNumber;
    private String accountName;
    private boolean status;
}
