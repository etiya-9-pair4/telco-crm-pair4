package com.etiya.customerservice.rule;

import com.etiya.customerservice.entity.Contact;
import com.etiya.customerservice.repository.ContactRepository.ContactRepository;
import io.github.anilaygun.exception.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ContactBusinessRules {

    private final ContactRepository contactRepository;
    private static final int MAX_CONTACTS_PER_CUSTOMER = 10;

    // 1. Same Email Rule
    public void checkIfContactEmailIsUniqueForCustomer(Integer customerId, String email) {
        Optional<Contact> existingContact = contactRepository.findByCustomerIdAndEmail(customerId, email);
        if (existingContact.isPresent()) {
            throw new BusinessException("A contact with this email already exists for this customer.");
        }
    }

    // 2. Contact Exists Rule
    public void checkIfContactExists(Integer contactId) {
        if (!contactRepository.existsById(contactId)) {
            throw new BusinessException("Contact not found.");
        }
    }

    // 3. Maximum Contacts Rule
    public void checkIfCustomerHasReachedMaxContacts(Integer customerId) {
        short contactCount = contactRepository.countByCustomerId(customerId);
        if (contactCount >= MAX_CONTACTS_PER_CUSTOMER) {
            throw new BusinessException("Customer has reached the maximum number of contacts.");
        }
    }

    public void checkIfMobilePhoneIsUnique(String mobilePhone) {
        if (contactRepository.findByMobilePhone(mobilePhone).isPresent()) {
            throw new BusinessException("A contact with the same mobile phone number already exists.");
        }
    }

    public void checkIfHomePhoneIsUnique(String homePhone) {
        if (contactRepository.findByHomePhone(homePhone).isPresent()) {
            throw new BusinessException("A contact with the same home phone number already exists.");
        }
    }

    public void checkIfEmailIsUnique(String email) {
        if (contactRepository.findByEmailIgnoreCase(email).isPresent()) {
            throw new BusinessException("A contact with the same Email already exists.");
        }
    }

}