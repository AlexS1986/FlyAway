package com.schlueter.flyaway.dao;

import com.schlueter.flyaway.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    // Add custom query methods if needed
}

