package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.Address.request.*;
import com.etiya.customerservice.dto.Address.response.*;
import com.etiya.customerservice.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AddressMapper {
    // create
    @Mapping(target = "customer.id", source = "customerId") // customerId'yi Address'teki customer.id'ye eşle
    @Mapping(target = "district.id", source = "districtId") // districtId'yi Address'teki district.id'ye eşle
    public abstract Address addressFromCreateRequest(CreateAddressRequestDto createAddressRequestDto);

    @Mapping(target = "customerId", source = "customer.id") // Address'teki customer.id, CreateAddressResponseDto'daki customerId'ye eşlenecek
    @Mapping(target = "districtId", source = "district.id") // district.id'yi CreateAddressResponseDto'daki districtId'ye eşle
    public abstract CreateAddressResponseDto addressCreateResponseFromAddress(Address address);

    // update
    @Mapping(target = "customer.id", source = "customerId") // Güncellemelerde customerId'yi Address'teki customer.id'ye eşle
    @Mapping(target = "district.id", source = "districtId") // districtId'yi Address'teki district.id'ye eşle
    public abstract Address addressFromUpdateRequest(UpdateAddressRequestDto updateAddressRequestDto);

    @Mapping(target = "customerId", source = "customer.id") // Address'teki customer.id, UpdateAddressResponseDto'daki customerId'ye eşlenecek
    @Mapping(target = "districtId", source = "district.id") // district.id'yi UpdateAddressResponseDto'daki districtId'ye eşle
    public abstract UpdateAddressResponseDto addressUpdateResponseFromAddress(Address address);

    // delete
    @Mapping(target="id", source = "addressId") // DeleteAddressRequestDto'daki addressId'yi Address'teki id'ye eşle
    public abstract Address addressFromDeleteRequest(DeleteAddressRequestDto deleteAddressRequestDto);

    @Mapping(target="addressId", source = "id") // Address'teki id'yi DeleteAddressResponseDto'daki addressId'ye eşle
    public abstract DeleteAddressResponseDto addressDeleteResponseFromAddress(Address address);

    // Get By Address ID
    @Mapping(target="id", source = "addressId") // ListAddressRequestDto'daki addressId'yi Address'teki id'ye eşle
    public abstract Address addressFromListRequest(ListAddressRequestDto listAddressRequestDto);

    @Mapping(target="addressId", source = "id") // Address'teki id'yi ListAddressResponseDto'daki addressId'ye eşle
    @Mapping(target="districtId", source = "district.id") // district.id'yi ListAddressResponseDto'daki districtId'ye eşle
    public abstract ListAddressResponseDto addressResponseFromListAddress(Address address);

    // Get Addresses by Customer ID
    @Mapping(target="customer.id", source = "customerId") // ListAddressByCustomerIdRequestDto'daki customerId'yi Address'teki customer.id'ye eşle
    public abstract Address addressFromListRequestByCustomerId(ListAddressByCustomerIdRequestDto listAddressByCustomerIdRequestDto);

    @Mapping(target="customerId", source = "customer.id") // Address'teki customer.id, ListAddressByCustomerIdResponseDto'daki customerId'ye eşlenecek
    public abstract ListAddressByCustomerIdResponseDto addressResponseFromListAddressByCustomerId(Address address);

    // Get List
    public abstract List<Address> AddressFromListRequest(List<ListAddressRequestDto> listAddressRequestDtos); // ListAddressRequestDto listesinden Address listesini oluştur

    public abstract List<ListAddressResponseDto> addressResponseFromListAddress(List<Address> addresses); // Address listesinden ListAddressResponseDto listesini oluştur
}
