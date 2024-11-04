package com.etiya.customerservice.spec;

import com.etiya.customerservice.dto.IndividualCustomer.request.SearchIndividualCustomerRequestDto;
import com.etiya.customerservice.entity.IndividualCustomer;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CustomerSpecifications {

    public static Specification<IndividualCustomer> createSpecification(SearchIndividualCustomerRequestDto searchDto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // deletedDate kontrolü
            predicates.add(criteriaBuilder.isNull(root.get("deletedDate")));

            // ID
            if (searchDto.getCustomerId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), searchDto.getCustomerId()));
            }

            // Nationality ID
            if (searchDto.getNationalityId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("nationalityId"), searchDto.getNationalityId()));
            }

            // Account Number
            if (searchDto.getAccountNumber() != null && !searchDto.getAccountNumber().isBlank()) {
                Join<Object, Object> customerAccountJoin = root.join("customerAccounts", JoinType.LEFT);
                predicates.add(criteriaBuilder.like(customerAccountJoin.get("accountNumber"), "%" + searchDto.getAccountNumber() + "%"));
            }

            // First Name
            if (searchDto.getFirstName() != null && !searchDto.getFirstName().isBlank()) {
                predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + searchDto.getFirstName() + "%"));
            }

            // Middle Name
            if (searchDto.getMiddleName() != null && !searchDto.getMiddleName().isBlank()) {
                predicates.add(criteriaBuilder.like(root.get("middleName"), "%" + searchDto.getMiddleName() + "%"));
            }

            // Last Name
            if (searchDto.getLastName() != null && !searchDto.getLastName().isBlank()) {
                predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + searchDto.getLastName() + "%"));
            }

            // Mobile Phone
            if (searchDto.getMobilePhone() != null && !searchDto.getMobilePhone().isBlank()) {
                Join<Object, Object> contactJoin = root.join("contacts", JoinType.LEFT);
                predicates.add(criteriaBuilder.like(contactJoin.get("mobilePhone"), "%" + searchDto.getMobilePhone() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }



}

