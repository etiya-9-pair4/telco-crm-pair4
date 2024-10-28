package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.ListIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.Gender;
import com.etiya.customerservice.entity.IndividualCustomer;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class IndividualCustomerMapper {

    //create
//    @Mapping(target = "addresses", source = "addressIds", qualifiedByName = "mapAddressIdsToCustomer")
    public abstract IndividualCustomer IndCustomerFromCreateRequest(CreateIndCustomerRequestDto createIndCustomerRequestDto);
    public abstract CreateIndCustomerResponseDto IndCustomerCreateResponseFromCustomer(IndividualCustomer individualCustomer);

    //update
    public abstract void IndCustomerFromUpdateRequest(UpdateIndCustomerRequestDto updateIndCustomerRequestDto,
                                                      @MappingTarget IndividualCustomer individualCustomer);

    public abstract UpdateIndCustomerResponseDto IndCustomerUpdateResponseFromCustomer(IndividualCustomer individualCustomer);

    //delete
    @Mapping(target="id", source = "customerId")
    public abstract IndividualCustomer IndCustomerFromDeleteRequest(DeleteIndCustomerRequestDto deleteIndCustomerRequestDto);
    @Mapping(target="customerId", source = "id")
    public abstract DeleteIndCustomerResponseDto IndCustomerDeleteResponseFromCustomer(IndividualCustomer individualCustomer);

    //GetById
    @Mapping(target="id", source = "customerId")
    public abstract IndividualCustomer IndCustomerFromListRequest(ListIndCustomerRequestDto listIndCustomerRequestDto);
    @Mapping(target="customerId", source = "id")
    public abstract ListIndCustomerResponseDto IndCustomerResponseFromCustomer(IndividualCustomer individualCustomer);


    //Get(List)
    @Mapping(target="id", source = "customerId")
    public abstract List<IndividualCustomer> IndCustomerFromListRequest(List<ListIndCustomerRequestDto> listIndCustomerRequestDto);
    public abstract List<ListIndCustomerResponseDto> IndCustomerResponseFromListCustomer(List<IndividualCustomer> individualCustomer);


}
