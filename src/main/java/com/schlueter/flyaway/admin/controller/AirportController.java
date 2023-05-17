package com.schlueter.flyaway.controller;

import com.schlueter.flyaway.entity.Airline;
import com.schlueter.flyaway.entity.Airport;
import com.schlueter.flyaway.service.AirlineService;
import com.schlueter.flyaway.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/airports")
public class AirportController {
    private AirportService airportService;


    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/list")
    public String getAirports(Model model) {
        List<Airport> airports = airportService.findAll();
        model.addAttribute("airports",airports);
        return "airports/list-airports";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Airport airport = new Airport();
        model.addAttribute("airport", airport);
        return "airports/airport-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("airportId") int id, Model model) {
        Airport airport = airportService.findById(id);
        model.addAttribute("airport", airport);
        return "airports/airport-form";
    }

    @PostMapping("/save")
    public String saveAirline(@ModelAttribute("airport") Airport airport) {
        airportService.save(airport);

        return "redirect:/airports/list";
    }

    @GetMapping("/delete")
    public String deleteAirline(@RequestParam("airportId") long id) {
        airportService.deleteById(id);
        return "redirect:/airports/list";
    }
}
