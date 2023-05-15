package com.schlueter.flyaway.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "airline")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "source")
    private Airport sourceAirport;

    @ManyToOne
    @JoinColumn(name = "destination")
    private Airport destinationAirport;

    @Column(name = "departure_datetime")
    private LocalDateTime departureDateTime;

    @Column(name = "ticket_price")
    private BigDecimal ticketPrice;

    public Flight() {
        // No-args constructor
    }

    public Flight(Airline airline, Airport sourceAirport, Airport destinationAirport, LocalDateTime departureDateTime, BigDecimal ticketPrice) {
        this.airline = airline;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.departureDateTime = departureDateTime;
        this.ticketPrice = ticketPrice;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(Airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
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

