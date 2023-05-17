package com.schlueter.flyaway.controller;

import com.schlueter.flyaway.entity.*;
import com.schlueter.flyaway.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Currency;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private FlightService flightService;

    private CustomerService customerService;

    private BookingService bookingService;



    @Autowired
    public BookingController(BookingService bookingService, FlightService flightService, CustomerService customerService) {
        this.customerService = customerService;
        this.flightService = flightService;
        this.bookingService = bookingService;
    }

    @GetMapping("/list")
    public String listBookings(Model theModel) {
        List<Booking> bookings = bookingService.findAll();
        theModel.addAttribute("bookings", bookings);

        Currency currency = Currency.getInstance("USD");
        theModel.addAttribute("currency", currency);

        return "bookings/list-bookings";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Booking booking = new Booking();
        booking.setId(0);
        model.addAttribute("booking", booking);
        List<Flight> flights = flightService.findAll();
        model.addAttribute("flights", flights);
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "bookings/booking-form";
    }

    @PostMapping("/save")
    public String saveBooking(@ModelAttribute("booking") BookingResponse bookingResponse) {
        Flight flight = flightService.findById(bookingResponse.getFlight());
        Customer customer = customerService.findById(bookingResponse.getCustomer());

        // TODO make constructor call
        Booking booking = new Booking();
        booking.setId(bookingResponse.getId());
        booking.setFlight(flight);
        booking.setCustomer(customer);
        booking.setNumberOfPersons(bookingResponse.getNumberOfPersons());
        bookingService.save(booking);

        return "redirect:/bookings/list";
    }

    @GetMapping("/delete")
    public String deleteBooking(@RequestParam("bookingId") int id) {
        bookingService.deleteById(id);
        return "redirect:/bookings/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookingId") int id, Model model) {
        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);
        List<Flight> flights = flightService.findAll();
        model.addAttribute("flights", flights);
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "bookings/booking-form";
    }

}
