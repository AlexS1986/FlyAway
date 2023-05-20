package com.schlueter.flyaway.controller.customer;

import java.time.LocalDate;

public class FlightSearchQuery {

    private int id;
    private int airline;
    private int sourceAirport;
    private int destinationAirport;

    private LocalDate departureDate;

    public FlightSearchQuery() {

    }

    public FlightSearchQuery(int airline, int sourceAirport, int destinationAirport, LocalDate departureDate) {
        this.airline = airline;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.departureDate = departureDate;
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

}
