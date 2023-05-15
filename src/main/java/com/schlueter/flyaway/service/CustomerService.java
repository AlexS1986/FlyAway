package com.schlueter.flyaway.service;


import com.schlueter.flyaway.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(long id);

    @Transactional
    void deleteById(long id);

    @Transactional
    void save(Customer customer);
}
