package com.etiya.customerservice.repository.ContactRepository;

import com.etiya.customerservice.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findByCustomerId(Integer customerId);

    Optional<Contact> findByCustomerIdAndEmail(Integer customerId, String email);

    Optional<Contact> findByMobilePhone(String mobilePhone);

    Optional<Contact> findByHomePhone(String homePhone);

    Optional<Contact> findByEmailIgnoreCase(String email);


    short countByCustomerId(Integer customerId);
}