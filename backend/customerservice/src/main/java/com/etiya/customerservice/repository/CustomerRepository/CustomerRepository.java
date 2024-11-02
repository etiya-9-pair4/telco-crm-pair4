package com.etiya.customerservice.repository.CustomerRepository;

import com.etiya.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository<T extends Customer> extends JpaRepository<T, Integer> {
    T getCustomerById(Integer customerId);
    List<Customer> findAllByDeletedDateIsNull();
}



