package com.etiya.customerservice.repository.ContactRepository;

import com.etiya.customerservice.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findByCustomer_Id(Integer customerId); // Belirli bir müşteri ID'sine göre iletişim bilgilerini alır.
}