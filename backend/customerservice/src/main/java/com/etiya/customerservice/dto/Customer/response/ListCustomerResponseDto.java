package com.etiya.customerservice.dto.Customer.response;

import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCustomerResponseDto {
    private Integer customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private int nationalityId;
    private List<Contact> contacts;
    private List<Address> addresses;
}