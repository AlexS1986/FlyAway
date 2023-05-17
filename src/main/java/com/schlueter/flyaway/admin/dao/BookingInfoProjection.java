package com.schlueter.flyaway.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

    public interface BookingInfoProjection {
        Long getBookingNumber();
        String getFirstName();
        String getLastName();
        int getNumberOfPersons();
        String getSourceAirport();
        String getDestinationAirport();
        LocalDateTime getFlightDate();
        BigDecimal getTotalPrice();
    }


