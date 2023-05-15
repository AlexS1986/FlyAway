package com.schlueter.flyaway.controller;

public class BookingResponse {

    private int id;
    private int flight;
    private int customer;
    private int numberOfPersons;

    public BookingResponse(int flight, int customer, int numberOfPersons) {
        this.flight = flight;
        this.customer = customer;
        this.numberOfPersons = numberOfPersons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }

    public long getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public long getFlight() {
        return this.flight;
    }
}
