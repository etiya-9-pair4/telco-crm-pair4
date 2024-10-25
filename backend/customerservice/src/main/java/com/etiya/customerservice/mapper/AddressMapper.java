package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.Address.request.*;
import com.etiya.customerservice.dto.Address.response.*;
import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.ListIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.IndividualCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AddressMapper {

    //create
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "district.id", source = "districtId")
    public abstract Address addressFromCreateRequest(CreateAddressRequestDto createAddressRequestDto);
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "districtId", source = "district.id")
    public abstract CreateAddressResponseDto addressCreateResponseFromAddress(Address address);

    //update
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "district.id", source = "districtId")
    public abstract Address addressFromUpdateRequest(UpdateAddressRequestDto updateAddressRequestDto);
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "districtId", source = "district.id")
    public abstract UpdateAddressResponseDto addressUpdateResponseFromAddress(Address address);

    //delete
    @Mapping(target="id", source = "addressId")
    public abstract Address addressFromDeleteRequest(DeleteAddressRequestDto deleteAddressRequestDto);
    @Mapping(target="addressId", source = "id")
    public abstract DeleteAddressResponseDto addressDeleteResponseFromAddress(Address address);

    //GetByIdAddressId
    @Mapping(target="id", source = "addressId")
    public abstract Address addressFromListRequest(ListAddressRequestDto listAddressRequestDto);
    @Mapping(target="addressId", source = "id")
    @Mapping(target="districtId", source = "district.id")
    public abstract ListAddressResponseDto addressResponseFromListAddress(Address address);

    //GetByIdCustomerId
    @Mapping(target="id", source = "customerId")
    public abstract Address addressFromListRequestByCustomerId(ListAddressByCustomerIdRequestDto listAddressByCustomerIdRequestDto);
    @Mapping(target="customerId", source = "customer.id")
    public abstract ListAddressByCustomerIdResponseDto addressResponseFromListAddressByCustomerId(Address address);

    //Get(List)
    @Mapping(target="id", source = "addressId")
    public abstract List<Address> AddressFromListRequest(List<ListAddressRequestDto> listAddressRequestDtos);
    @Mapping(target="addressId", source = "id")
    public abstract List<ListAddressResponseDto> addressResponseFromListAddress(List<Address> addresses);

}
