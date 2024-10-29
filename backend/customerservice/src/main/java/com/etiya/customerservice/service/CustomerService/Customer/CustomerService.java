package com.etiya.customerservice.service.CustomerService.Customer;

import com.etiya.customerservice.dto.Customer.request.CreateCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.request.DeleteCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.request.UpdateCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.response.*;
import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CreateCustomerResponseDto add(CreateCustomerRequestDto createCustomerRequestDto);
    UpdateCustomerResponseDto update(UpdateCustomerRequestDto updateCustomerRequestDto);
    DeleteCustomerResponseDto delete(DeleteCustomerRequestDto deleteCustomerRequestDto);
    Optional<CustomerResponseDto> getById(Integer id);
    List<CustomerResponseDto> getAll();

    ListCustomerResponseDto getCustomerDetails(Integer id);
}
