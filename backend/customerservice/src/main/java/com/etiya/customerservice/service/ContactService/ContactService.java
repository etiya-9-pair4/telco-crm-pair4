package com.etiya.customerservice.service.ContactService;


import com.etiya.customerservice.dto.Contact.request.CreateContactRequestDto;
import com.etiya.customerservice.dto.Contact.request.DeleteContactRequestDto;
import com.etiya.customerservice.dto.Contact.request.UpdateContactRequestDto;
import com.etiya.customerservice.dto.Contact.response.*;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    CreateContactResponseDto add(CreateContactRequestDto createContactRequestDto);

    UpdateContactResponseDto update(UpdateContactRequestDto updateContactRequestDto);

    DeleteContactResponseDto delete(DeleteContactRequestDto deleteContactRequestDto);

    Optional<ListContactResponseDto> getById(Integer id);

    List<ListContactByCustomerIdResponseDto> getAllContactsByCustomerId(Integer customerId);

    List<ListContactResponseDto> getAll();
}
