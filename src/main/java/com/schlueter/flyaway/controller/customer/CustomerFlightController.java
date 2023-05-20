package com.schlueter.flyaway.controller.customer;

import com.schlueter.flyaway.entity.Airline;
import com.schlueter.flyaway.entity.Airport;
import com.schlueter.flyaway.entity.Flight;
import com.schlueter.flyaway.service.AirlineService;
import com.schlueter.flyaway.service.AirportService;
import com.schlueter.flyaway.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customer/flights")
public class CustomerFlightController {
    private FlightService flightService;

    private AirlineService airlineService;

    private AirportService airportService;

    @Autowired
    public CustomerFlightController(FlightService flightService,
                                    AirlineService airlineService,
                                    AirportService airportService) {
        this.flightService = flightService;
        this.airportService = airportService;
        this.airlineService = airlineService;
    }


    @GetMapping("/search")
    public String showFormForAdd(Model model) {
        FlightSearchQuery flightQuery = new FlightSearchQuery();
        flightQuery.setId(0);
        model.addAttribute("flightQuery", flightQuery);
        List<Airline> airlines = airlineService.findAll();
        model.addAttribute("airlines", airlines);
        List<Airport> airports = airportService.findAll();
        model.addAttribute("airports", airports);
        return "customer/flights/flight-form";
    }

    @PostMapping("/search/results")
    public String listFLights(@ModelAttribute("flightQuery") FlightSearchQuery flightSearchQuery,
                              Model model) {
        List<Flight> flights =
                flightService.findAll().stream()
                        .filter(f -> {
                            if(flightSearchQuery.getAirline() != 0) {
                                return f.getAirline().getId() == flightSearchQuery.getAirline();
                            } else {
                                return true;
                            }
                        })
                       .filter(f -> {
                                    if(flightSearchQuery.getDepartureDate() != null) {
                                        return f.getDepartureDateTime().getYear() == flightSearchQuery.getDepartureDate().getYear()
                                                && f.getDepartureDateTime().getMonth() == flightSearchQuery.getDepartureDate().getMonth()
                                                && f.getDepartureDateTime().getDayOfMonth() == flightSearchQuery.getDepartureDate().getDayOfMonth();
                                    } else {
                                        return true;
                                    }
                                }
                        )
                        .filter(f -> {
                            if(flightSearchQuery.getSourceAirport() != 0) {
                                return f.getSourceAirport().getId() == flightSearchQuery.getSourceAirport();
                            } else {
                                return true;
                            }
                        })
                        .filter(f -> {
                            if(flightSearchQuery.getDestinationAirport() != 0) {
                                return f.getDestinationAirport().getId() == flightSearchQuery.getDestinationAirport();
                            } else {
                                return true;
                            }
                        })
                        .collect(Collectors.toList());
        model.addAttribute("flights", flights);

        Currency currency = Currency.getInstance("USD");
        model.addAttribute("currency", currency);
        return "customer/flights/list-flights";
    }
}
