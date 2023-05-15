package com.schlueter.flyaway.service;

import com.schlueter.flyaway.entity.Airline;
import com.schlueter.flyaway.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AirlineService {
    List<Airline> findAll();

    Airline findById(long id);

    @Transactional
    void save(Airline airline);

    @Transactional
    void deleteById(long id);
}
