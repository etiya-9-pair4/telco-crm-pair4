package com.etiya.customerservice.dto.Customer.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequestDto {
    private Integer customerId;
    private List<Integer> addressIds;
    private List<Integer> contactIds;
    private List<Integer> customerAccountIds;
}
