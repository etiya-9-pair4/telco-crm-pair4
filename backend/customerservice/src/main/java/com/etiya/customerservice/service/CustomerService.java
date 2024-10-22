package com.etiya.customerservice.service;

import com.etiya.customerservice.dto.request.CreateCustomerRequestDto;
import com.etiya.customerservice.dto.request.DeleteCustomerRequestDto;
import com.etiya.customerservice.dto.request.UpdateCustomerRequestDto;
import com.etiya.customerservice.dto.response.CreateCustomerResponseDto;
import com.etiya.customerservice.dto.response.DeleteCustomerResponseDto;
import com.etiya.customerservice.dto.response.ListCustomerResponseDto;
import com.etiya.customerservice.dto.response.UpdateCustomerResponseDto;

import java.util.List;

public interface CustomerService {
    //ListCustomerResponseDto getById(Integer id);

    List<ListCustomerResponseDto> getAll();

    //List<ListCustomerResponseDto> getByName(String name);

    DeleteCustomerResponseDto delete(DeleteCustomerRequestDto deleteCustomerRequestDto);

    CreateCustomerResponseDto add(CreateCustomerRequestDto createCustomerRequestDto);

    UpdateCustomerResponseDto update(UpdateCustomerRequestDto updateCustomerRequestDto);
}
