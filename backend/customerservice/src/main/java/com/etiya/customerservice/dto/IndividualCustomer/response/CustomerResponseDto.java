package com.etiya.customerservice.dto.IndividualCustomer.response;

import com.etiya.customerservice.dto.Address.response.ListAddressResponseDto;
import com.etiya.customerservice.dto.Contact.response.ListContactResponseDto;
import com.etiya.customerservice.dto.CustomerAccount.response.ListCustomerAccountResponseDto;
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
public class CustomerResponseDto {
    private Integer customerId;
    private long nationalityId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer genderId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
    private List<ListContactResponseDto> contacts;
    private List<ListAddressResponseDto> addresses;
    private List<ListCustomerAccountResponseDto> customerAccounts;

}
