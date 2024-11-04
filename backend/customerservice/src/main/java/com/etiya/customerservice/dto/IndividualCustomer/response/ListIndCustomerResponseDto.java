package com.etiya.customerservice.dto.IndividualCustomer.response;

import com.etiya.customerservice.dto.Address.response.ListAddressResponseDto;
import com.etiya.customerservice.dto.Contact.response.ListContactResponseDto;
import com.etiya.customerservice.dto.CustomerAccount.response.ListCustomerAccountResponseDto;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.Contact;
import com.etiya.customerservice.entity.CustomerAccount;
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
public class ListIndCustomerResponseDto {
    private Integer customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private long nationalityId;
    private List<ListContactResponseDto> contacts;
    private List<ListAddressResponseDto> addresses;
    private List<ListCustomerAccountResponseDto> customerAccounts;
    

}
