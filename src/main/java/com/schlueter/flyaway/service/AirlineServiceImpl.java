package com.schlueter.flyaway.service;

import com.schlueter.flyaway.dao.AirlineRepository;
import com.schlueter.flyaway.dao.FlightRepository;
import com.schlueter.flyaway.entity.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineService{

    private AirlineRepository airlineRepository;
    //private FlightRepository flightRepository;

    @Autowired
    public AirlineServiceImpl(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
        //this.flightRepository = flightRepository;
    }

    @Override
    public List<Airline> findAll() {
        return this.airlineRepository.findAll();
    }

    @Override
    public Airline findById(long id) {
        return airlineRepository.findById(id).orElseThrow(() -> new RuntimeException(" Airline not found - " + id));
    }

    @Override
    public void save(Airline airline) {
        airlineRepository.save(airline);
    }

    @Override
    public void deleteById(long id) {
        //flightRepository.deleteFlightsByAirlineId(id);
        airlineRepository.deleteById(id);
    }
}
