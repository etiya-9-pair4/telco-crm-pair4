package com.etiya.customerservice.service.ContactService;

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

public interface ContactService {
    CreateIndCustomerResponseDto add(CreateIndCustomerRequestDto createIndCustomerRequestDto);

    UpdateIndCustomerResponseDto update(UpdateIndCustomerRequestDto updateIndCustomerRequestDto);

    DeleteIndCustomerResponseDto delete(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto);

    //ListIndCustomerResponseDto getById(Integer id);
    Optional<Customer> getCustomerById(Integer id); //productservice -> CustomerServiceClient için yapılmıştır. ListIndCustomerResponseDto belirlendiğinde değiştirilebilir.

    List<ListIndCustomerResponseDto> getAll();

    //List<ListIndCustomerResponseDto> getByName(String name);


}
