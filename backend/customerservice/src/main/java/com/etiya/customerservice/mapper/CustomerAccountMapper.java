package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.Contact.request.ListContactByCustomerIdRequestDto;
import com.etiya.customerservice.dto.CustomerAccount.request.*;
import com.etiya.customerservice.dto.CustomerAccount.response.*;
import com.etiya.customerservice.entity.CustomerAccount;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerAccountMapper {
    // create
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "type.id", source = "typeId")
    //  @Mapping(target = "address.id", source = "addressId")
    CustomerAccount customerAccountFromCreateRequest(CreateCustomerAccountRequestDto requestDto);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "typeId", source = "type.id")
        //  @Mapping(target = "addressId", source = "address.id")
    CreateCustomerAccountResponseDto customerAccountCreateResponseFromEntity(CustomerAccount customerAccount);

    // delete
    CustomerAccount customerAccountDeleteResponseFromEntity(DeleteCustomerAccountRequestDto requestDto);

    @Mapping(target = "customerId", source = "customer.id")
    DeleteCustomerAccountResponseDto customerAccountDeleteResponseFromEntity(CustomerAccount customerAccount);

    // update
    @Mapping(target = "customer.id", source = "customerId")
    //   @Mapping(target = "address.id", source = "addressId")
    @Mapping(target = "type.id", source = "typeId")
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CustomerAccount customerAccountFromUpdateRequest(UpdateCustomerAccountRequestDto requestDto, @MappingTarget CustomerAccount customerAccount);

    @Mapping(target = "customerId", source = "customer.id")
    //  @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "typeId", source = "type.id")
    UpdateCustomerAccountResponseDto customerAccountUpdateResponseFromEntity(CustomerAccount customerAccount);

    // Get Addresses by Customer ID
    @Mapping(target = "customer.id", source = "customerId")
    public abstract CustomerAccount customerAccountFromListByCustomerIdRequest(ListContactByCustomerIdRequestDto listContactByCustomerIdRequestDto);

    //   @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "typeId", source = "type.id")
    ListCustomerAccountByCustomerIdResponseDto customerAccountResponseFromListByCustomerId(CustomerAccount customerAccount);

    // Get List
    public abstract CustomerAccount customerAccountListFromListRequest(ListCustomerAccountRequestDto requestDtos);

    @Mapping(target = "customerId", source = "customer.id")
    //  @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "typeId", source = "type.id")
    ListCustomerAccountResponseDto customerAccountResponseFromList(CustomerAccount customerAccount);

    @Mapping(target = "customerId", source = "customer.id")
    //  @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "typeId", source = "type.id")
    List<ListCustomerAccountResponseDto> customerAccountResponseListFromCustomerAccount(List<CustomerAccount> customerAccounts);

}

