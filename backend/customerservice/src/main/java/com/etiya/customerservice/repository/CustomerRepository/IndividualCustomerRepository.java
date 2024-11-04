package com.etiya.customerservice.repository.CustomerRepository;

import com.etiya.customerservice.entity.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface IndividualCustomerRepository extends CustomerRepository<IndividualCustomer>, JpaSpecificationExecutor<IndividualCustomer> {
    List<IndividualCustomer> findByFirstNameAndLastName(String firstName, String lastName);
    IndividualCustomer findByNationalityId(long nationalityId);
}
