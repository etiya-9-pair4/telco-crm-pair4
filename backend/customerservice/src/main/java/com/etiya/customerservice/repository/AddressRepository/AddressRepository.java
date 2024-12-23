package com.etiya.customerservice.repository.AddressRepository;

import com.etiya.customerservice.dto.Address.response.ListAddressByCustomerIdResponseDto;
import com.etiya.customerservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCustomerId(Integer customerId);

    Optional<Address> findByCustomerIdAndIsDefaultTrue(Integer customerId);


}

