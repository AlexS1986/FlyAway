package com.schlueter.flyaway.dao;

import com.schlueter.flyaway.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    // Add custom query methods if needed
}
