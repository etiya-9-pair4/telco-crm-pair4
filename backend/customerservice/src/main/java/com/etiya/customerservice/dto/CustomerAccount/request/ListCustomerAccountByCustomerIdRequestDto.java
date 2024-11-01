package com.etiya.customerservice.dto.CustomerAccount.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListCustomerAccountByCustomerIdRequestDto {
    private Integer customerId;
}
