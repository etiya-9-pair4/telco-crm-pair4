package com.etiya.customerservice.rule;

import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.repository.CustomerRepository.IndividualCustomerRepository;
import io.github.anilaygun.exception.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomerBusinessRules {

    private final IndividualCustomerRepository individualCustomerRepository;

    public void customerWithSameNationalityId(long nationalityId) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findByNationalityId(nationalityId);
        if (individualCustomer != null) {
            throw new BusinessException("There is a customer with the same Nationality ID.");
        }
    }

    public void checkIfCustomerIsActive(Integer customerId) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.getCustomerById(customerId);

        if (individualCustomer.isPresent() && individualCustomer.get().getDeletedDate() != null) {
            throw new BusinessException("Customer is already inactive.");
        }
    }

    public void checkIfCustomerHasCustomerAccount(Integer customerId) {
        IndividualCustomer individualCustomer = individualCustomerRepository.getCustomerById(customerId);
        if (!individualCustomer.getCustomerAccounts().isEmpty()) {
            throw new BusinessException("Customer has an associated CustomerAccount and cannot be deleted.");
        }
    }

    public void checkIfCustomerExists(Integer customerId) {
        if (!individualCustomerRepository.existsById(customerId)) {
            throw new BusinessException("Customer not found.");
        }
    }

    public void customerAgeMustBeAbove18(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        int age = Period.between(dateOfBirth, today).getYears();
        if (age < 18) {
            throw new BusinessException("Customer must be above 18 years old.");
        }
    }
    public void validateNationalityIdLength(long nationalityId) {
        if (nationalityId < 10000000000L || nationalityId > 99999999999L) {
            throw new BusinessException("Nationality ID must be exactly 11 digits long.");
        }
    }
}
