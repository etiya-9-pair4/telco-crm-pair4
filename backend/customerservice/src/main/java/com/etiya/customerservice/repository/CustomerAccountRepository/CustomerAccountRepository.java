package com.etiya.customerservice.repository.CustomerAccountRepository;

import com.etiya.customerservice.dto.CustomerAccount.request.ListCustomerAccountByCustomerIdRequestDto;
import com.etiya.customerservice.dto.CustomerAccount.response.ListCustomerAccountByCustomerIdResponseDto;
import com.etiya.customerservice.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Integer> {

    List<CustomerAccount> findByCustomer_Id(Integer customerId);
}
