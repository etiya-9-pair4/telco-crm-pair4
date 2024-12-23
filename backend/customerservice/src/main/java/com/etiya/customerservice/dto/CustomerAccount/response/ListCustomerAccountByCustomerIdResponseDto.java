package com.etiya.customerservice.dto.CustomerAccount.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCustomerAccountByCustomerIdResponseDto {
    private Integer id;
    private List<Integer> addressIds;
    private Integer typeId;
    private String accountNumber;
    private String accountName;
    private boolean status;
}
