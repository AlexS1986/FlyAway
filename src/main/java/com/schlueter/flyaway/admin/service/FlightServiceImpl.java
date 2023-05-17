package com.schlueter.flyaway.service;

import com.schlueter.flyaway.dao.FlightRepository;
import com.schlueter.flyaway.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    private FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    @Override
    public List<Flight> findAll() {
        return this.flightRepository.findAll();
    }

    @Override
    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void deleteById(long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public Flight findById(long id) {
        return flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found - " +id));
    }
}
