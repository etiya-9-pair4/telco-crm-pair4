package com.etiya.customerservice.service;

import com.etiya.customerservice.dto.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CreateIndCustomerResponseDto add(CreateIndCustomerRequestDto createIndCustomerRequestDto);

    UpdateIndCustomerResponseDto update(UpdateIndCustomerRequestDto updateIndCustomerRequestDto);

    DeleteIndCustomerResponseDto delete(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto);

    //ListIndCustomerResponseDto getById(Integer id);
    Optional<Customer> getCustomerById(Integer id); //productservice -> CustomerServiceClient için yapılmıştır. ListIndCustomerResponseDto belirlendiğinde değiştirilebilir.

    List<ListIndCustomerResponseDto> getAll();

    //List<ListIndCustomerResponseDto> getByName(String name);


}
