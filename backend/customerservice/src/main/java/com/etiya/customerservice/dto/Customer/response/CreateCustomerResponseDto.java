package com.etiya.customerservice.dto.Customer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerResponseDto {
    private Integer customerId;
    private LocalDateTime createdDate;

}
