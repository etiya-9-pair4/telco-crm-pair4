package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.Contact.request.ListContactByCustomerIdRequestDto;
import com.etiya.customerservice.dto.CustomerAccount.request.*;
import com.etiya.customerservice.dto.CustomerAccount.response.*;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.CustomerAccount;
import org.mapstruct.*;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerAccountMapper {
    // Create
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "addresses", source = "addressIds", qualifiedByName = "mapToAddresses") // addressIds'den addresses'e eşleştir
    CustomerAccount customerAccountFromCreateRequest(CreateCustomerAccountRequestDto requestDto);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "addressIds", source = "addresses", qualifiedByName = "mapAddressIds") // addresses'den addressIds'e eşleştir
    CreateCustomerAccountResponseDto customerAccountCreateResponseFromEntity(CustomerAccount customerAccount);

    // Delete
    CustomerAccount customerAccountDeleteResponseFromEntity(DeleteCustomerAccountRequestDto requestDto);

    @Mapping(target = "customerId", source = "customer.id")
    DeleteCustomerAccountResponseDto customerAccountDeleteResponseFromEntity(CustomerAccount customerAccount);

    // Update
    @Mapping(target = "addresses", source = "addressIds", qualifiedByName = "mapToAddresses") // Güncelleme sırasında da eşleştirme
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CustomerAccount customerAccountFromUpdateRequest(UpdateCustomerAccountRequestDto requestDto, @MappingTarget CustomerAccount customerAccount);


    @Mapping(target = "addressIds", source = "addresses", qualifiedByName = "mapAddressIds") // Güncelleme sonrası eşleştirme
    UpdateCustomerAccountResponseDto customerAccountUpdateResponseFromEntity(CustomerAccount customerAccount);

    // Get Addresses by Customer ID
    @Mapping(target = "customer.id", source = "customerId")
    CustomerAccount customerAccountFromListByCustomerIdRequest(ListContactByCustomerIdRequestDto listContactByCustomerIdRequestDto);

    @Mapping(target = "addressIds", source = "addresses", qualifiedByName = "mapAddressIds")
    ListCustomerAccountByCustomerIdResponseDto customerAccountResponseFromListByCustomerId(CustomerAccount customerAccount);

    // Get List
    CustomerAccount customerAccountListFromListRequest(ListCustomerAccountRequestDto requestDtos);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "addressIds", source = "addresses", qualifiedByName = "mapAddressIds") // Get list sırasında da eşleştir
    ListCustomerAccountResponseDto customerAccountResponseFromList(CustomerAccount customerAccount);

    @Mapping(target = "customerId", source = "customer.id")
    List<ListCustomerAccountResponseDto> customerAccountResponseListFromCustomerAccount(List<CustomerAccount> customerAccounts);

    // Özel eşleştirme yöntemleri
    @Named("mapAddressIds")
    default List<Integer> mapAddressIds(List<Address> addresses) {
        return addresses != null ? addresses.stream().map(Address::getId).collect(Collectors.toList()) : null;
    }

    @Named("mapToAddresses")
    default List<Address> mapToAddresses(List<Integer> addressIds) {
        return addressIds != null ? addressIds.stream().map(id -> {
            Address address = new Address();
            address.setId(id);
            return address;
        }).collect(Collectors.toList()) : null;
    }
}
