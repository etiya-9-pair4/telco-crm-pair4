package com.etiya.customerservice.repository.CustomerRepository;

import com.etiya.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepository<T extends Customer> extends JpaRepository<T, Integer> {
    Optional<Customer> getCustomerById(Integer customerId);
}

