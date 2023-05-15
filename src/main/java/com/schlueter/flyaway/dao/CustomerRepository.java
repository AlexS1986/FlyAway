package com.schlueter.flyaway.dao;

import com.schlueter.flyaway.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Add custom query methods if needed
}

