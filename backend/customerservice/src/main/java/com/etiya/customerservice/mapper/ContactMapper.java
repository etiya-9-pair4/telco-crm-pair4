package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.Contact.request.*;
import com.etiya.customerservice.dto.Contact.response.*;
import com.etiya.customerservice.entity.Contact;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ContactMapper {
    // Create
    @Mapping(target = "customer.id", source = "customerId")
    public abstract Contact contactFromCreateRequest(CreateContactRequestDto createContactRequestDto);

    @Mapping(target = "contactId", source = "id")
    @Mapping(target = "customerId", source = "customer.id")
    public abstract CreateContactResponseDto contactCreateResponseFromContact(Contact contact);

    // Update
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Contact contactFromUpdateRequest(UpdateContactRequestDto updateContactRequestDto, @MappingTarget Contact contact);

    @Mapping(target = "contactId", source = "id")
    @Mapping(target = "customerId", source = "customer.id")
    public abstract UpdateContactResponseDto contactUpdateResponseFromContact(Contact contact);

    // Delete
    @Mapping(target = "id", source = "contactId")
    public abstract Contact contactFromDeleteRequest(DeleteContactRequestDto deleteContactRequestDto);

    @Mapping(target = "contactId", source = "id")
    @Mapping(target = "customerId", source = "customer.id")
    public abstract DeleteContactResponseDto contactDeleteResponseFromContact(Contact contact);

    // Get By Id
    @Mapping(target = "id", source = "contactId")
    public abstract Contact contactFromListRequest(ListContactRequestDto listContactRequestDto);

    @Mapping(target = "contactId", source = "id")
    @Mapping(target = "customerId", source = "customer.id")
    public abstract ListContactResponseDto contactResponseFromListContact(Contact contact);

    // Get By Customer Id
    @Mapping(target = "customer.id", source = "customerId")
    public abstract Contact contactFromListRequestByCustomerId(ListContactByCustomerIdRequestDto listContactByCustomerIdRequestDto);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "contactId", source = "contact.id")
    public abstract ListContactByCustomerIdResponseDto contactResponseFromListContactByCustomerId(Contact contact);

    // Get List
    @Mapping(target = "id", source = "contactId")
    public abstract List<Contact> contactFromListRequest(List<ListContactRequestDto> listContactRequestDtos);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "contactId", source = "contact.id")
    public abstract List<ListContactResponseDto> contactResponseFromListContact(List<Contact> contacts);
}
