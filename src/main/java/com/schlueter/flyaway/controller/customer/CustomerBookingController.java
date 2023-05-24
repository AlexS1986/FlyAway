package com.schlueter.flyaway.controller.customer;

import com.schlueter.flyaway.controller.admin.BookingResponse;
import com.schlueter.flyaway.entity.Booking;
import com.schlueter.flyaway.entity.Customer;
import com.schlueter.flyaway.entity.Flight;
import com.schlueter.flyaway.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer/bookings")
public class CustomerBookingController {

    private FlightService flightService;

    private CustomerService customerService;

    private BookingService bookingService;

    private PaymentService paymentService;

    @Autowired
    public CustomerBookingController(FlightService flightService,
                                     CustomerService customerService,
                                     BookingService bookingService,
                                     PaymentService paymentService) {
        this.flightService = flightService;
        this.customerService = customerService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }

    @GetMapping("showBookingCustomerForm")
    public String showFormForBookingCustomer(@RequestParam("flightId") int flightId,@RequestParam(value = "paymentFailed", required = false) String paymentFailed, Model model) {

        BookingForm bookingForm = new BookingForm();
        bookingForm.setNumberOfPersons(1);
        //bookingForm.setId(0);

        /*Booking booking = new Booking();
        booking.setId(0);


        Flight flight = flightService.findById(flightId);
        booking.setFlight(flight); */


        model.addAttribute("flightId", flightId);
        model.addAttribute("booking", bookingForm);
        boolean paymentFailedBool = paymentFailed == null ? false : true;model.addAttribute("paymentFailed", paymentFailedBool);
        return "customer/bookings/booking-form";
    }

    @PostMapping("/save")
    public String saveBooking(@ModelAttribute("booking") BookingForm bookingForm, Model model) throws PaymentException {
        Flight flight = flightService.findById(bookingForm.getFlight());

        Customer customer = new Customer(
                bookingForm.getCustomerFirstName(),
                bookingForm.getCustomerLastName(),
                bookingForm.getCustomerEmail(),
                String.valueOf(bookingForm.getCustomerPhoneNumber())
        );
        customer = customerService.save(customer);
        // TODO this needs to be a transaction
        try {
            paymentService.conductPayment(
                    bookingForm.getNumberOfPersons() * flight.getTicketPrice().doubleValue(),
                    bookingForm.getCreditCardNumber());
        } catch (PaymentException p) {
            throw new PaymentException(p.getMessage(), flight.getId());
        }



        // TODO make constructor call
        Booking booking = new Booking();
        booking.setId(bookingForm.getId());
        booking.setFlight(flight);
        booking.setCustomer(customer);
        booking.setNumberOfPersons(bookingForm.getNumberOfPersons());
        booking = bookingService.save(booking);

        model.addAttribute("booking", booking);
        return "customer/bookings/booking-confirmation";
    }

}
