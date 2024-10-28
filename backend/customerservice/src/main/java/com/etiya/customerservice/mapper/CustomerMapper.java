package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.Customer.request.CreateCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.request.UpdateCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.response.CreateCustomerResponseDto;
import com.etiya.customerservice.dto.Customer.response.CustomerResponseDto;
import com.etiya.customerservice.dto.Customer.response.UpdateCustomerResponseDto;
import com.etiya.customerservice.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    Customer toCustomer(CreateCustomerRequestDto dto);

    @Mapping(target = "customerId", source = "id")
    CreateCustomerResponseDto toCreateCustomerResponseDto(Customer customer);

    @Mapping(target = "id", ignore = true)
    Customer updateCustomerFromRequest(UpdateCustomerRequestDto dto, @MappingTarget Customer customer);

    @Mapping(target = "customerId", source = "id")
    UpdateCustomerResponseDto toUpdateCustomerResponseDto(Customer customer);

    CustomerResponseDto toCustomerResponseDto(Customer customer);
}
