package com.schlueter.flyaway.security;

import com.schlueter.flyaway.service.PaymentException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PaymentException.class)
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlePaymentException(PaymentException ex, HttpServletRequest request) {
        //ModelAndView modelAndView = new ModelAndView("redirect:/home/");  // Specify the redirect URL
        //modelAndView.addObject("error", ex.getMessage());
        //redirectAttributes.addAttribute("error", "true");
        //System.out.println("QueryString:!!!" + request.getQueryString());

        return  "redirect:/customer/bookings/showBookingCustomerForm?flightId="+ex.getFligtId()+"&paymentFailed";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "redirect:/home?err";
    }

    // Add more exception handling methods for specific exceptions
}
