package com.schlueter.flyaway.controller;

import com.schlueter.flyaway.entity.Airline;
import com.schlueter.flyaway.entity.Airport;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlightResponse {

    private int id;
    private int airline;
    private int sourceAirport;
    private int destinationAirport;

    private LocalDateTime departureDateTime;

    private BigDecimal ticketPrice;


    public FlightResponse(int airline, int sourceAirport, int destinationAirport, LocalDateTime departureDateTime, BigDecimal ticketPrice) {
        this.airline = airline;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.departureDateTime = departureDateTime;
        this.ticketPrice = ticketPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAirline() {
        return airline;
    }

    public void setAirline(int airline) {
        this.airline = airline;
    }

    public int getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(int sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public int getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(int destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
