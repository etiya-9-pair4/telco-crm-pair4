package com.etiya.customerservice.dto.CustomerAccount.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerAccountRequestDto {
    @NotNull
    private Integer id;
    @NotNull
    private Integer customerId;
    private List<Integer> addressIds;
    @NotNull
    private Integer typeId;
    private String accountNumber; //?
    @NotNull
    private String accountName;
    @NotNull
    private boolean status;
}
