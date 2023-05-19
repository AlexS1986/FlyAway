package com.schlueter.flyaway.controller.admin;

import com.schlueter.flyaway.entity.Booking;
import com.schlueter.flyaway.entity.Customer;
import com.schlueter.flyaway.entity.Flight;
import com.schlueter.flyaway.service.BookingService;
import com.schlueter.flyaway.service.CustomerService;
import com.schlueter.flyaway.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;
import java.util.List;

@Controller
@RequestMapping("/admin/bookings")
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

        return "admin/bookings/list-bookings";
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
        return "admin/bookings/booking-form";
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

        return "redirect:/admin/bookings/list";
    }

    @GetMapping("/delete")
    public String deleteBooking(@RequestParam("bookingId") int id) {
        bookingService.deleteById(id);
        return "redirect:/admin/bookings/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookingId") int id, Model model) {
        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);
        List<Flight> flights = flightService.findAll();
        model.addAttribute("flights", flights);
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "admin/bookings/booking-form";
    }

}
