package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.IndividualCustomer.request.CreateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.ListIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.CreateIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.IndividualCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class   CustomerMapper {

    //create
    @Mapping(target = "gender.id", source = "genderId")
//    @Mapping(target = "addresses", source = "addressIds", qualifiedByName = "mapAddressIdsToCustomer")
    public abstract IndividualCustomer IndCustomerFromCreateRequest(CreateIndCustomerRequestDto createIndCustomerRequestDto);
    @Mapping(target="genderId", source = "gender.id")
    public abstract CreateIndCustomerResponseDto IndCustomerCreateResponseFromCustomer(IndividualCustomer individualCustomer);

    //update
    @Mapping(target="gender.id", source = "genderId")
    @Mapping(target="id", source = "customerId")
    public abstract IndividualCustomer IndCustomerFromUpdateRequest(UpdateIndCustomerRequestDto updateIndCustomerRequestDto);
    @Mapping(target="genderId", source = "gender.id")
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
    public abstract ListIndCustomerResponseDto IndCustomerResponseFromListCustomer(IndividualCustomer individualCustomer);


    //Get(List)
    @Mapping(target="id", source = "customerId")
    public abstract List<IndividualCustomer> IndCustomerFromListRequest(List<ListIndCustomerRequestDto> listIndCustomerRequestDto);
    public abstract List<ListIndCustomerResponseDto> IndCustomerResponseFromListCustomer(List<IndividualCustomer> individualCustomer);


//    @Named("mapAddressIdsToCustomer")
//    protected List<Address> mapAddressIdsToEntities(List<Integer> addressIds) {
//        // Burada addressIds listesinden Address entity’lerini döndürecek kod
//        return addressIds.stream()
//                .map(id -> new Address(id)) // ID ile Address yarat
//                .collect(Collectors.toList());
//    }

}
