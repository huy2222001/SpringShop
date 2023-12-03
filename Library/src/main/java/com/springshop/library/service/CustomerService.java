package com.springshop.library.service;

import com.springshop.library.dto.CustomerDto;
import com.springshop.library.model.Customer;

public interface CustomerService {
    Customer save(CustomerDto customerDto);

    Customer findByUsername(String username);

    CustomerDto getCustomer(String username);

    Customer update(CustomerDto customerDto);
}
