package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.Contact.request.*;
import com.etiya.customerservice.dto.Contact.response.*;
import com.etiya.customerservice.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ContactMapper {
    // Create
    @Mapping(target = "customer.id", source = "customerId") // CreateContactRequestDto'dan customerId alıyoruz
    public abstract Contact contactFromCreateRequest(CreateContactRequestDto createContactRequestDto);

    @Mapping(target = "contactId", source = "id") // Contact'tan id'yi contactId'ye eşliyoruz
    @Mapping(target = "customerId", source = "customer.id") // Contact'tan customer.id'yi customerId'ye eşliyoruz
    public abstract CreateContactResponseDto contactCreateResponseFromContact(Contact contact);

    // Update
    @Mapping(target = "customer.id", source = "customerId") // UpdateContactRequestDto'dan customerId alıyoruz
    @Mapping(target = "id", source = "contactId") // UpdateContactRequestDto'dan contactId alıyoruz
    public abstract Contact contactFromUpdateRequest(UpdateContactRequestDto updateContactRequestDto);

    @Mapping(target = "contactId", source = "id") // Contact'tan id'yi contactId'ye eşliyoruz
    @Mapping(target = "customerId", source = "customer.id") // Contact'tan customer.id'yi customerId'ye eşliyoruz
    public abstract UpdateContactResponseDto contactUpdateResponseFromContact(Contact contact);

    // Delete
    @Mapping(target = "id", source = "contactId") // DeleteContactRequestDto'dan contactId alıyoruz
    public abstract Contact contactFromDeleteRequest(DeleteContactRequestDto deleteContactRequestDto);

    @Mapping(target = "contactId", source = "id") // Contact'tan id'yi contactId'ye eşliyoruz
    public abstract DeleteContactResponseDto contactDeleteResponseFromContact(Contact contact);

    // Get By Id
    @Mapping(target = "id", source = "contactId") // ListContactRequestDto'dan contactId alıyoruz
    public abstract Contact contactFromListRequest(ListContactRequestDto listContactRequestDto);

    @Mapping(target = "contactId", source = "id") // Contact'tan id'yi contactId'ye eşliyoruz
    public abstract ListContactResponseDto contactResponseFromListContact(Contact contact);

    // Get By Customer Id
    @Mapping(target = "customer.id", source = "customerId") // ListContactByCustomerIdRequestDto'dan customerId alıyoruz
    public abstract Contact contactFromListRequestByCustomerId(ListContactByCustomerIdRequestDto listContactByCustomerIdRequestDto);

    @Mapping(target = "customerId", source = "customer.id") // Contact'tan customer.id'yi customerId'ye eşliyoruz
    public abstract ListContactByCustomerIdResponseDto contactResponseFromListContactByCustomerId(Contact contact);

    // Get List
    public abstract List<Contact> contactFromListRequest(List<ListContactRequestDto> listContactRequestDtos);

    public abstract List<ListContactResponseDto> contactResponseFromListContact(List<Contact> contacts);
}
