package com.etiya.customerservice.repository.CustomerRepository;

import com.etiya.customerservice.entity.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerRepository extends CustomerRepository<IndividualCustomer>{
    List<IndividualCustomer> findByFirstNameAndLastName(String firstName, String lastName);
}
