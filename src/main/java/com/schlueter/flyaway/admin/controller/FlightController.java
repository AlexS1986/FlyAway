package com.schlueter.flyaway.controller;

import com.schlueter.flyaway.entity.Airline;
import com.schlueter.flyaway.entity.Airport;
import com.schlueter.flyaway.entity.Employee;
import com.schlueter.flyaway.entity.Flight;
import com.schlueter.flyaway.service.AirlineService;
import com.schlueter.flyaway.service.AirportService;
import com.schlueter.flyaway.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Currency;

@Controller
@RequestMapping("/flights")
public class FlightController {

    private FlightService flightService;

    private AirlineService airlineService;

    private AirportService airportService;

    @Autowired
    public FlightController(FlightService flightService, AirlineService airlineService,
                            AirportService airportService) {
        this.airlineService = airlineService;
        this.flightService = flightService;
        this.airportService = airportService;
    }

    @GetMapping("/list")
    public String listFlights(Model theModel) {
        List<Flight> flights = flightService.findAll();
        Currency currency = Currency.getInstance("USD");

        // add to the spring model
        theModel.addAttribute("flights", flights);
        theModel.addAttribute("currency", currency);

        return "flights/list-flights";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Flight flight = new Flight();
        flight.setId(0);
        model.addAttribute("flight", flight);
        List<Airline> airlines = airlineService.findAll();
        model.addAttribute("airlines", airlines);
        List<Airport> airports = airportService.findAll();
        model.addAttribute("airports", airports);
        return "flights/flight-form";
    }

    @PostMapping("/save")
    public String saveFlight(@ModelAttribute("flight") FlightResponse flightResponse) {
        Airline airline = airlineService.findById(flightResponse.getAirline());
        Airport source = airportService.findById(flightResponse.getSourceAirport());
        Airport destination = airportService.findById(flightResponse.getDestinationAirport());

        Flight flight = new Flight();
        flight.setId(flightResponse.getId());
        flight.setAirline(airline);
        flight.setSourceAirport(source);
        flight.setDestinationAirport(destination);
        flight.setTicketPrice(flightResponse.getTicketPrice());
        flight.setDepartureDateTime(flightResponse.getDepartureDateTime());
        flightService.save(flight);

        return "redirect:/flights/list";
    }

    @GetMapping("/delete")
    public String deleteFlight(@RequestParam("flightId") int id) {
        flightService.deleteById(id);
        return "redirect:/flights/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("flightId") int id, Model model) {
        Flight flight = flightService.findById(id);
        model.addAttribute("flight", flight);
        List<Airline> airlines = airlineService.findAll();
        model.addAttribute("airlines", airlines);
        List<Airport> airports = airportService.findAll();
        model.addAttribute("airports", airports);
        return "flights/flight-form";
    }

}
