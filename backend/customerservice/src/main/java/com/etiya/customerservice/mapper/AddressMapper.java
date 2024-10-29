package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.Address.request.*;
import com.etiya.customerservice.dto.Address.response.*;
import com.etiya.customerservice.entity.Address;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AddressMapper {
    // create
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "district.id", source = "districtId")
    public abstract Address addressFromCreateRequest(CreateAddressRequestDto createAddressRequestDto);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "districtId", source = "district.id")
    @Mapping(target = "addressId", source = "id")
    public abstract CreateAddressResponseDto addressCreateResponseFromAddress(Address address);

    // update
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "district.id", source = "districtId")
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Address updateAddressFromRequest(UpdateAddressRequestDto updateAddressRequestDto, @MappingTarget Address address);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "districtId", source = "district.id")
    @Mapping(target = "addressId", source = "id")
    public abstract UpdateAddressResponseDto addressUpdateResponseFromAddress(Address address);

    // delete
    @Mapping(target = "id", source = "addressId")
    public abstract Address addressFromDeleteRequest(DeleteAddressRequestDto deleteAddressRequestDto);

    @Mapping(target = "addressId", source = "id")
    @Mapping(target = "customerId", source = "customer.id")
    public abstract DeleteAddressResponseDto addressDeleteResponseFromAddress(Address address);

    // Get By Address ID
    @Mapping(target = "id", source = "addressId")
    public abstract Address addressFromListRequest(ListAddressRequestDto listAddressRequestDto);

    @Mapping(target = "addressId", source = "id")
    @Mapping(target = "districtId", source = "district.id")
    @Mapping(target = "customerId", source = "customer.id")
    public abstract ListAddressResponseDto addressResponseFromListAddress(Address address);

    // Get Addresses by Customer ID
    @Mapping(target = "customer.id", source = "customerId")
    public abstract Address addressFromListRequestByCustomerId(ListAddressByCustomerIdRequestDto listAddressByCustomerIdRequestDto);

    @Mapping(target = "addressId", source = "id")
    @Mapping(target = "districtId", source = "district.id")
    public abstract ListAddressByCustomerIdResponseDto addressResponseFromListAddressByCustomerId(Address address);

    // Get List
    @Mapping(target = "id", source = "addressId")
    public abstract List<Address> AddressFromListRequest(List<ListAddressRequestDto> listAddressRequestDtos);

    @Mapping(target = "addressId", source = "id")
    @Mapping(target = "districtId", source = "district.id")
    @Mapping(target = "customerId", source = "customer.id")
    public abstract List<ListAddressResponseDto> addressResponseFromListAddress(List<Address> addresses);
}
