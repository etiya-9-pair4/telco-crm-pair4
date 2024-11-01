package com.etiya.customerservice.service.ContactService;

import com.etiya.customerservice.dto.Contact.request.CreateContactRequestDto;
import com.etiya.customerservice.dto.Contact.request.DeleteContactRequestDto;
import com.etiya.customerservice.dto.Contact.request.UpdateContactRequestDto;
import com.etiya.customerservice.dto.Contact.response.*;
import com.etiya.customerservice.entity.Contact;
import com.etiya.customerservice.mapper.ContactMapper;
import com.etiya.customerservice.repository.ContactRepository.ContactRepository;
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

    @Transactional
    @Override
    public CreateContactResponseDto add(CreateContactRequestDto createContactRequestDto) {
        Contact contact = contactMapper.contactFromCreateRequest(createContactRequestDto);
        contactRepository.save(contact);
        return contactMapper.contactCreateResponseFromContact(contact);
    }

    @Transactional
    @Override
    public UpdateContactResponseDto update(UpdateContactRequestDto updateContactRequestDto) {
        Contact existingContact = contactRepository.findById(updateContactRequestDto.getContactId())
                .orElseThrow(() -> new RuntimeException("Contact not found"));
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
    public Optional<ListContactResponseDto> getById(Integer id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        ListContactResponseDto contactResponseDto = contactMapper.contactResponseFromListContact(contact);
        return Optional.of(contactResponseDto);
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
