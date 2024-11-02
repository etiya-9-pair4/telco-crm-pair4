package com.etiya.customerservice.repository.CustomerRepository;

import com.etiya.customerservice.entity.IndividualCustomer;

import java.util.List;
import java.util.Optional;

public interface IndividualCustomerRepository extends CustomerRepository<IndividualCustomer>{
    List<IndividualCustomer> findByFirstNameAndLastName(String firstName, String lastName);
    IndividualCustomer findByNationalityId(long nationalityId);
}
