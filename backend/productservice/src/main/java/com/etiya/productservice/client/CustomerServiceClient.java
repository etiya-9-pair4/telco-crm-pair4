package com.etiya.productservice.client;

import com.etiya.productservice.dto.customer.CustomerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customerservice")
public interface CustomerServiceClient {

    @GetMapping("api/customers/{id}")
    CustomerResponseDto getCustomerById(@PathVariable("id") Integer id);

}
