package com.etiya.customerservice.dto.Customer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {
    private Integer customerId;
    private List<Integer> addressIds;
    private List<Integer> contactIds;
    private List<Integer> customerAccountIds;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
