package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.Contact.request.*;
import com.etiya.customerservice.dto.Contact.response.*;
import com.etiya.customerservice.dto.IndividualCustomer.request.DeleteIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.ListIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.request.UpdateIndCustomerRequestDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.DeleteIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.ListIndCustomerResponseDto;
import com.etiya.customerservice.dto.IndividualCustomer.response.UpdateIndCustomerResponseDto;
import com.etiya.customerservice.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ContactMapper {

    //create
    @Mapping(target = "customer.id", source = "customerId")
    public abstract Contact contactFromCreateRequest(CreateContactRequestDto createContactRequestDto);
    @Mapping(target="customerId", source = "customer.id")
    public abstract CreateContactResponseDto contactCreateResponseFromContact(Contact contact);

    //update
    @Mapping(target="customer.id", source = "customerId")
    @Mapping(target="id", source = "contactId")
    public abstract Contact contactFromUpdateRequest(UpdateContactRequestDto updateContactRequestDto);
    @Mapping(target="customerId", source = "customer.id")
    public abstract UpdateContactResponseDto contactUpdateResponseFromContact(Contact contact);

    //delete
    @Mapping(target="id", source = "contactId")
    public abstract Contact contactFromDeleteRequest(DeleteContactRequestDto deleteContactRequestDto);
    @Mapping(target="contactId", source = "id")
    public abstract DeleteContactResponseDto contactDeleteResponseFromCustomer(Contact contact);

    //GetById
    @Mapping(target="id", source = "contactId")
    public abstract Contact ContactFromListRequest(ListContactRequestDto listContactRequestDto);
    @Mapping(target="contactId", source = "id")
    public abstract ListContactResponseDto contactResponseFromListContact(Contact contact);
    //GetByIdCustomerId
    @Mapping(target="customer.id", source = "customerId")
    public abstract Contact contactFromListRequestByCustomerId(ListContactByCustomerIdRequestDto listContactByCustomerIdRequestDto);
    @Mapping(target="customerId", source = "customer.id")
    public abstract ListContactByCustomerIdResponseDto contactResponseFromListContactByCustomerId(Contact contact);

    //Get(List)
    @Mapping(target="id", source = "contactId")
    public abstract List<Contact> contactFromListRequest(List<ListContactRequestDto> listContactRequestDtos);
    @Mapping(target="contactId", source = "id")
    public abstract List<ListContactRequestDto> contactResponseFromListContact(List<Contact> contacts);
}
