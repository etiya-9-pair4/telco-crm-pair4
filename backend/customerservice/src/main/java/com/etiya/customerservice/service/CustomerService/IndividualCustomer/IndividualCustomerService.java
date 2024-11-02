package com.etiya.customerservice.service.CustomerService.IndividualCustomer;

import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.ListIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerService {
    CreateIndCustomerResponseDto add(CreateIndCustomerRequestDto createIndCustomerRequestDto);

    UpdateIndCustomerResponseDto update(UpdateIndCustomerRequestDto updateIndCustomerRequestDto);

    DeleteIndCustomerResponseDto delete(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto);

    ListIndCustomerResponseDto getById(ListIndCustomerRequestDto listIndCustomerRequestDto);

    IndividualCustomer getCustomerById(Integer id); //productservice -> CustomerServiceClient için yapılmıştır. ListIndCustomerResponseDto belirlendiğinde değiştirilebilir.

    List<ListIndCustomerResponseDto> getAll();

    List<IndividualCustomer> findByFirstNameAndLastName(String firstName, String lastName);


    //List<ListIndCustomerResponseDto> getByName(String name);


}
