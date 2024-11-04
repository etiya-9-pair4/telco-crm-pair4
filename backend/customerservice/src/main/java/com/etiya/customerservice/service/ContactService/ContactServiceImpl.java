package com.etiya.customerservice.service.ContactService;

import com.etiya.customerservice.dto.Contact.request.CreateContactRequestDto;
import com.etiya.customerservice.dto.Contact.request.DeleteContactRequestDto;
import com.etiya.customerservice.dto.Contact.request.UpdateContactRequestDto;
import com.etiya.customerservice.dto.Contact.response.*;
import com.etiya.customerservice.entity.Contact;
import com.etiya.customerservice.mapper.ContactMapper;
import com.etiya.customerservice.repository.ContactRepository.ContactRepository;
import com.etiya.customerservice.rule.ContactBusinessRules;
import io.github.anilaygun.exception.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;
    private final ContactBusinessRules contactBusinessRules;

    @Transactional
    @Override
    public CreateContactResponseDto add(CreateContactRequestDto createContactRequestDto) {
        Contact contact = contactMapper.contactFromCreateRequest(createContactRequestDto);

        contactBusinessRules.checkIfContactEmailIsUniqueForCustomer(createContactRequestDto.getCustomerId(), createContactRequestDto.getEmail());
        contactBusinessRules.checkIfMobilePhoneIsUnique(createContactRequestDto.getMobilePhone());
        contactBusinessRules.checkIfHomePhoneIsUnique(createContactRequestDto.getHomePhone());
        contactBusinessRules.checkIfCustomerHasReachedMaxContacts(createContactRequestDto.getCustomerId());

        contactRepository.save(contact);
        return contactMapper.contactCreateResponseFromContact(contact);
    }

    @Transactional
    @Override
    public UpdateContactResponseDto update(UpdateContactRequestDto updateContactRequestDto) {

        contactBusinessRules.checkIfContactExists(updateContactRequestDto.getContactId());

        Contact existingContact = contactRepository.getReferenceById(updateContactRequestDto.getContactId());
        contactBusinessRules.checkIfContactEmailIsUniqueForCustomer(updateContactRequestDto.getCustomerId(), updateContactRequestDto.getEmail());
        contactBusinessRules.checkIfMobilePhoneIsUnique(updateContactRequestDto.getMobilePhone());
        contactBusinessRules.checkIfHomePhoneIsUnique(updateContactRequestDto.getHomePhone());

        Contact updatedContact = contactMapper.contactFromUpdateRequest(updateContactRequestDto, existingContact);
        contactRepository.save(updatedContact);
        return contactMapper.contactUpdateResponseFromContact(updatedContact);
    }

    @Transactional
    @Override
    public DeleteContactResponseDto delete(DeleteContactRequestDto deleteContactRequestDto) {
        Contact contact = contactRepository.findById(deleteContactRequestDto.getContactId())
                .orElseThrow(() -> new RuntimeException("Contact not found"));
        contactRepository.delete(contact);
        return contactMapper.contactDeleteResponseFromContact(contact);
    }

    @Override
    public ListContactResponseDto getById(Integer id) {
        contactBusinessRules.checkIfContactExists(id);

        Contact existingContact = contactRepository.getReferenceById(id);
        ListContactResponseDto contactResponseDto = contactMapper.contactResponseFromListContact(existingContact);
        return contactResponseDto;
    }


    @Override
    public List<ListContactByCustomerIdResponseDto> getAllContactsByCustomerId(Integer customerId) {
        List<Contact> contacts = contactRepository.findByCustomerId(customerId);
        return contacts.stream()
                .map(contactMapper::contactResponseFromListContactByCustomerId)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListContactResponseDto> getAll() {
        List<Contact> contacts = contactRepository.findAll();

        List<ListContactResponseDto> responseDtos = contactMapper.contactResponseFromListContact(contacts);
        return responseDtos;
    }
}
