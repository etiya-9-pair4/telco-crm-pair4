package com.etiya.customerservice.dto.IndividualCustomer.request;


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
public class DeleteIndCustomerRequestDto {
    @NotNull
    private Integer customerId;
}
