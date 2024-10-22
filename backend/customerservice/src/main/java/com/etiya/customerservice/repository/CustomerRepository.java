package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> getCustomerById(Integer customerId);
}
