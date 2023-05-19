package com.schlueter.flyaway.controller.admin;

import com.schlueter.flyaway.entity.Airline;
import com.schlueter.flyaway.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/airlines")
public class AirlineController {
    private AirlineService airlineService;


    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/list")
    public String getAirlines(Model model) {
        List<Airline> airlines = airlineService.findAll();
        model.addAttribute("airlines",airlines);
        return "admin/airlines/list-airlines";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Airline airline = new Airline();
        model.addAttribute("airline", airline);
        return "admin/airlines/airline-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("airlineId") int id, Model model) {
        Airline airline = airlineService.findById(id);
        model.addAttribute("airline", airline);
        return "admin/airlines/airline-form";
    }

    @PostMapping("/save")
    public String saveAirline(@ModelAttribute("airline") Airline airline) {
        airlineService.save(airline);

        return "redirect:/admin/airlines/list";
    }

    @GetMapping("/delete")
    public String deleteAirline(@RequestParam("airlineId") long id) {
        airlineService.deleteById(id);
        return "redirect:/admin/airlines/list";
    }
}
