package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.Address.response.ListAddressResponseDto;
import com.etiya.customerservice.dto.Contact.response.ListContactResponseDto;
import com.etiya.customerservice.dto.CustomerAccount.response.ListCustomerAccountResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.ListIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.*;
import com.etiya.customerservice.entity.*;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IndividualCustomerMapper {

    @Mapping(target = "customerId", source = "id")
    @Mapping(target = "nationalityId", source = "nationalityId")
    @Mapping(target = "accountNumber", source = "customerAccounts", qualifiedByName = "mapFirstAccountNumber")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "middleName", source = "middleName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "mobilePhone", source = "contacts", qualifiedByName = "mapFirstMobilePhone")
    SearchIndividualCustomerResponseDto toSearchResponseDto(IndividualCustomer individualCustomer);

    @Named("mapFirstAccountNumber")
    static String mapFirstAccountNumber(List<CustomerAccount> customerAccounts) {
        return customerAccounts != null && !customerAccounts.isEmpty() ? customerAccounts.get(0).getAccountNumber() : null;
    }

    @Named("mapFirstMobilePhone")
    static String mapFirstMobilePhone(List<Contact> contacts) {
        return contacts != null && !contacts.isEmpty() ? contacts.get(0).getMobilePhone() : null;
    }

    // create
    IndividualCustomer IndCustomerFromCreateRequest(CreateIndCustomerRequestDto createIndCustomerRequestDto);

    CreateIndCustomerResponseDto IndCustomerCreateResponseFromCustomer(IndividualCustomer individualCustomer);

    // update
    IndividualCustomer IndCustomerFromUpdateRequest(UpdateIndCustomerRequestDto updateIndCustomerRequestDto,
                                                    @MappingTarget IndividualCustomer individualCustomer);

    UpdateIndCustomerResponseDto IndCustomerUpdateResponseFromCustomer(IndividualCustomer individualCustomer);

    // delete
    @Mapping(target = "id", source = "customerId")
    IndividualCustomer IndCustomerFromDeleteRequest(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto);

    @Mapping(target = "customerId", source = "id")
    DeleteIndCustomerResponseDto IndCustomerDeleteResponseFromCustomer(IndividualCustomer individualCustomer);

    // GetById
    @Mapping(target = "id", source = "customerId")
    IndividualCustomer IndCustomerFromListRequest(ListIndCustomerRequestDto listIndCustomerRequestDto);

    @Mapping(target = "customerId", source = "id")
    CustomerResponseDto IndCustomerResponseFromCustomerId(IndividualCustomer individualCustomer);

    // Main mapping
    @Mapping(target = "customerId", source = "id")
    @Mapping(target = "contacts", source = "contacts")
    @Mapping(target = "addresses", source = "addresses")
    @Mapping(target = "customerAccounts", source = "customerAccounts")
    ListIndCustomerResponseDto IndCustomerResponseFromCustomer(IndividualCustomer individualCustomer);

    // Mapping for nested DTOs
    @Mapping(target = "contactId", source = "id")
    @Mapping(target = "customerId", source = "customer.id")
    ListContactResponseDto mapContact(Contact contact);

    @Mapping(target = "addressId", source = "id")
    @Mapping(target = "districtId", source = "district.id")
    @Mapping(target = "customerId", source = "customer.id")
    ListAddressResponseDto mapAddress(Address address);


    @Mapping(target = "addressIds", source = "addresses", qualifiedByName = "mapAddressIds")
    ListCustomerAccountResponseDto mapCustomerAccount(CustomerAccount customerAccount);

    // Get(List)
    @Mapping(target = "id", source = "customerId")
    List<IndividualCustomer> IndCustomerFromListRequest(List<ListIndCustomerRequestDto> listIndCustomerRequestDto);

    List<ListIndCustomerResponseDto> IndCustomerResponseFromListCustomer(List<IndividualCustomer> individualCustomer);

    @Named("mapAddressIds")
    static List<Integer> mapAddressIds(List<Address> addresses) {
        return addresses.stream().map(Address::getId).collect(Collectors.toList());
    }


}
