package com.schlueter.flyaway.service;

import com.schlueter.flyaway.entity.Flight;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FlightService {
    List<Flight> findAll();

    @Transactional
    void save(Flight flight);

    @Transactional
    void deleteById(long id);

    Flight findById(long id);
}
