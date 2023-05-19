package com.schlueter.flyaway.controller.customer;

import com.schlueter.flyaway.dao.FlightRepository;
import com.schlueter.flyaway.entity.Flight;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer/flights")
public class CustomerFlightController {
    private FlightRepository flightRepository;

    public CustomerFlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    @GetMapping("/list")
    public String listFLights(@RequestParam(value = "airlineShortName", required = false) String airlineShortName, Model model) {
        List<Flight> flights = new ArrayList<>();
        if (airlineShortName != null) {
            flights = flightRepository.findByAirlineShortName(airlineShortName);
        } else {
            flights = flightRepository.findAll();
        }

        model.addAttribute("flights", flights);
        return "customer/flights/list-flights";
    }
}
