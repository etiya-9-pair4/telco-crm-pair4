package com.etiya.customerservice.service;

import com.etiya.customerservice.dto.request.CreateCustomerRequestDto;
import com.etiya.customerservice.dto.request.DeleteCustomerRequestDto;
import com.etiya.customerservice.dto.request.UpdateCustomerRequestDto;
import com.etiya.customerservice.dto.response.CreateCustomerResponseDto;
import com.etiya.customerservice.dto.response.DeleteCustomerResponseDto;
import com.etiya.customerservice.dto.response.ListCustomerResponseDto;
import com.etiya.customerservice.dto.response.UpdateCustomerResponseDto;
import com.etiya.customerservice.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    //ListCustomerResponseDto getById(Integer id);
    Optional<Customer> getCustomerById(Integer id); //productservice -> CustomerServiceClient için yapılmıştır. ListCustomerResponseDto belirlendiğinde değiştirilebilir.

    List<ListCustomerResponseDto> getAll();

    //List<ListCustomerResponseDto> getByName(String name);

    DeleteCustomerResponseDto delete(DeleteCustomerRequestDto deleteCustomerRequestDto);

    CreateCustomerResponseDto add(CreateCustomerRequestDto createCustomerRequestDto);

    UpdateCustomerResponseDto update(UpdateCustomerRequestDto updateCustomerRequestDto);


}
