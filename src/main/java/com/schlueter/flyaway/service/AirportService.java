package com.schlueter.flyaway.service;

import com.schlueter.flyaway.entity.Airport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AirportService {
    List<Airport> findAll();

    Airport findById(long id);

    @Transactional
    void save(Airport airport);

    @Transactional
    void deleteById(long id);
}
