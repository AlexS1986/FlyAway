package com.schlueter.flyaway.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column(name = "number_of_persons")
    private int numberOfPersons;

    public Booking() {

    }

    public Booking(Customer customer, Flight flight, int numberOfPersons) {
        this.customer = customer;
        this.flight = flight;
        this.numberOfPersons = numberOfPersons;
    }


    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}

