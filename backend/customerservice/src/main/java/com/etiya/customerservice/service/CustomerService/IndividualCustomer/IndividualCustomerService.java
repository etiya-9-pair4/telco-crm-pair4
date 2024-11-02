package com.etiya.customerservice.service.CustomerService.IndividualCustomer;

import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.*;
import com.etiya.customerservice.entity.IndividualCustomer;

import java.util.List;
import java.util.Optional;

public interface IndividualCustomerService {
    CreateIndCustomerResponseDto add(CreateIndCustomerRequestDto createIndCustomerRequestDto);

    UpdateIndCustomerResponseDto update(UpdateIndCustomerRequestDto updateIndCustomerRequestDto);

    DeleteIndCustomerResponseDto delete(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto);

    CustomerResponseDto getById(ListIndCustomerRequestDto listIndCustomerRequestDto);

    IndividualCustomer getCustomerById(Integer id); //productservice -> CustomerServiceClient için yapılmıştır. ListIndCustomerResponseDto belirlendiğinde değiştirilebilir.

    List<ListIndCustomerResponseDto> getAll();

    List<IndividualCustomer> findByFirstNameAndLastName(String firstName, String lastName);
    List<ListIndCustomerResponseDto> findAllByDeletedDateIsNull();


    //List<ListIndCustomerResponseDto> getByName(String name);


}
