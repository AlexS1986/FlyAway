package com.schlueter.flyaway.service;

import com.schlueter.flyaway.dao.BookingRepository;
import com.schlueter.flyaway.dao.CustomerRepository;
import com.schlueter.flyaway.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private BookingRepository bookingRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               BookingRepository bookingRepository) {
        this.customerRepository = customerRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not found - " +id));
    }


    @Override
    public void deleteById(long id) {
        bookingRepository.deleteBookingsByCustomerId(id);
        customerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
