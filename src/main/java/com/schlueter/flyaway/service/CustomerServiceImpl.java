package com.schlueter.flyaway.service;

import com.schlueter.flyaway.dao.BookingRepository;
import com.schlueter.flyaway.dao.CustomerRepository;
import com.schlueter.flyaway.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    //private BookingRepository bookingRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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
        customerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == 0 ) {
            // check if customer already exists
            Optional<Customer> customerOpt =
                    customerRepository.findByFirstNameAndLastNameAndEmail(
                            customer.getFirstName(),
                            customer.getLastName(),
                            customer.getEmail());
            if(customerOpt.isPresent()) {
                // is already present -> set Id
                customer.setId(customerOpt.get().getId());
            }
        }
        return customerRepository.save(customer);
    }
}
