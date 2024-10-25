package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.request.ListIndCustomerRequestDto;
import com.etiya.customerservice.dto.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {

    //create
    @Mapping(target="gender.id", source = "genderId")
    public abstract IndividualCustomer IndCustomerFromCreateRequest(CreateIndCustomerRequestDto createIndCustomerRequestDto);
    @Mapping(target="genderId", source = "gender.id")
    public abstract CreateIndCustomerResponseDto IndCustomerCreateResponseFromCustomer(IndividualCustomer individualCustomer);

    //update
    @Mapping(target="gender.id", source = "genderId")
    @Mapping(target="id", source = "customerId")
    public abstract IndividualCustomer IndCustomerFromUpdateRequest(UpdateIndCustomerRequestDto updateIndCustomerRequestDto);
    @Mapping(target="genderId", source = "gender.id")
    @Mapping(target="customerId", source = "id")
    public abstract UpdateIndCustomerResponseDto IndCustomerUpdateResponseFromCustomer(IndividualCustomer individualCustomer);

    //delete
    @Mapping(target="id", source = "customerId")
    public abstract IndividualCustomer IndCustomerFromDeleteRequest(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto);
    @Mapping(target="customerId", source = "id")
    public abstract DeleteIndCustomerResponseDto IndCustomerDeleteResponseFromCustomer(IndividualCustomer individualCustomer);

    //GetById
    @Mapping(target="id", source = "customerId")
    public abstract IndividualCustomer IndCustomerFromListRequest(ListIndCustomerRequestDto listIndCustomerRequestDto);
    public abstract ListIndCustomerResponseDto IndCustomerResponseFromListCustomer(IndividualCustomer individualCustomer);


    //Get(List)
    @Mapping(target="id", source = "customerId")
    public abstract List<IndividualCustomer> IndCustomerFromListRequest(List<ListIndCustomerRequestDto> listIndCustomerRequestDto);
    public abstract List<ListIndCustomerResponseDto> IndCustomerResponseFromListCustomer(List<IndividualCustomer> individualCustomer);

}
