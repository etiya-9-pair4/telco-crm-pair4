package com.etiya.customerservice.rule;

import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.repository.CustomerRepository.IndividualCustomerRepository;
import io.github.anilaygun.exception.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomerBusinessRules {

    private final IndividualCustomerRepository individualCustomerRepository;

    public void customerWithSameNationalityId(Integer nationalityId) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByNationalityId(nationalityId);

        if (individualCustomer.isPresent()) {
            throw new BusinessException("There is a customer with same Nationality ID.");

        }
    }

    public void checkIfCustomerIsActive(Integer customerId) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.getCustomerById(customerId);

        if (individualCustomer.isPresent() && individualCustomer.get().getDeletedDate() != null) {
            throw new BusinessException("Customer is already inactive.");
        }
    }

}
