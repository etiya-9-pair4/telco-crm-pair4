package com.etiya.customerservice.controller.ContactController;

import com.etiya.customerservice.dto.Contact.request.CreateContactRequestDto;
import com.etiya.customerservice.dto.Contact.request.DeleteContactRequestDto;
import com.etiya.customerservice.dto.Contact.request.UpdateContactRequestDto;
import com.etiya.customerservice.dto.Contact.response.CreateContactResponseDto;
import com.etiya.customerservice.dto.Contact.response.DeleteContactResponseDto;
import com.etiya.customerservice.dto.Contact.response.ListContactResponseDto;
import com.etiya.customerservice.dto.Contact.response.UpdateContactResponseDto;
import com.etiya.customerservice.service.ContactService.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<CreateContactResponseDto> createContact(@RequestBody @Valid CreateContactRequestDto createContactRequestDto) {
        CreateContactResponseDto responseDto = contactService.add(createContactRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping()
    public ResponseEntity<UpdateContactResponseDto> updateContact(@RequestBody @Valid UpdateContactRequestDto updateContactRequestDto) {
        UpdateContactResponseDto responseDto = contactService.update(updateContactRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping
    public ResponseEntity<DeleteContactResponseDto> deleteContact(@RequestBody @Valid DeleteContactRequestDto deleteContactRequestDto) {
        DeleteContactResponseDto responseDto = contactService.delete(deleteContactRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<Optional<ListContactResponseDto>> getById(@PathVariable Integer contactId) {
        Optional<ListContactResponseDto> contact = contactService.getById(contactId);
        return ResponseEntity.ok(contact);
    }

    @GetMapping
    public ResponseEntity<List<ListContactResponseDto>> getAll() {
        List<ListContactResponseDto> contacts = contactService.getAll();
        return ResponseEntity.ok(contacts);
    }
}
