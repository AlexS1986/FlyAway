package com.schlueter.flyaway.service;

import com.schlueter.flyaway.dao.AirportRepository;
import com.schlueter.flyaway.dao.FlightRepository;
import com.schlueter.flyaway.entity.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService{

    private AirportRepository airportRepository;
    //private FlightRepository flightRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
        //this.flightRepository = flightRepository;
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Airport findById(long id) {
        return airportRepository.findById(id).orElseThrow(() -> new RuntimeException("Airport not found - " + id));
    }

    @Override
    public void save(Airport airport) {
        airportRepository.save(airport);
    }

    @Override
    public void deleteById(long id) {
        //flightRepository.deleteFlightsByAirportId(id);
        airportRepository.deleteById(id);
    }
}
