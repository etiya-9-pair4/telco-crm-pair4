package com.etiya.customerservice.dto.CustomerAccount.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerAccountRequestDto {
    @NotNull
    private Integer customerId;
    @NotNull
    private Integer addressId; //?
    @NotNull
    private Integer typeId;
    private String accountNumber; //?
    @NotNull
    private String accountName;
    @NotNull
    private boolean status;
}
