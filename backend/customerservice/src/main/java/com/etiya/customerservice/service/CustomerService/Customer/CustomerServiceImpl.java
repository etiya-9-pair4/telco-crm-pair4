package com.etiya.customerservice.service.CustomerService.Customer;

import com.etiya.customerservice.dto.Customer.request.CreateCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.request.DeleteCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.request.UpdateCustomerRequestDto;
import com.etiya.customerservice.dto.Customer.response.*;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.Contact;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.mapper.CustomerMapper;
import com.etiya.customerservice.repository.AddressRepository.AddressRepository;
import com.etiya.customerservice.repository.ContactRepository.ContactRepository;
import com.etiya.customerservice.repository.CustomerRepository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerRepository<Customer> customerRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Transactional
    @Override
    public CreateCustomerResponseDto add(CreateCustomerRequestDto request) {
        Customer customer = customerMapper.toCustomer(request);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toCreateCustomerResponseDto(savedCustomer);
    }

    @Transactional
    @Override
    public UpdateCustomerResponseDto update(UpdateCustomerRequestDto request) {
        Customer existingCustomer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Customer updatedCustomer = customerMapper.updateCustomerFromRequest(request, existingCustomer);
        customerRepository.save(updatedCustomer);
        return customerMapper.toUpdateCustomerResponseDto(updatedCustomer);
    }

    @Transactional
    @Override
    public DeleteCustomerResponseDto delete(DeleteCustomerRequestDto request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customer);
        return new DeleteCustomerResponseDto(request.getCustomerId(), customer.getDeletedDate());
    }

    @Override
    public Optional<CustomerResponseDto> getById(Integer id) {
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerResponseDto);
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerResponseDto)
                .collect(Collectors.toList());
    }

    // Belirli bir müşteri için tüm bilgileri getirir
    public ListCustomerResponseDto getCustomerDetails(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // DTO'ya müşteri bilgilerini aktar
        ListCustomerResponseDto responseDto = customerMapper.toDto(customer);

        // İlgili Contact ve Address bilgilerini bul
        List<Contact> contacts = contactRepository.findByCustomerId(customerId);
        List<Address> addresses = addressRepository.findByCustomerId(customerId);

        // DTO'ya Contact ve Address bilgilerini ekle
        responseDto.setContacts(contacts);
        responseDto.setAddresses(addresses);

        return responseDto;
    }
}
