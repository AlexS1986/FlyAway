package com.schlueter.flyaway.controller.customer;

public class BookingForm {

    private int id;
    private int flight;

    private int numberOfPersons;

    private String customerFirstName;

    private String customerLastName;

    private String customerEmail;

    private Integer customerPhoneNumber;

    private Integer creditCardNumber;

    public Integer getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Integer creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public BookingForm() {
    }

    public BookingForm(int flight, int numberOfPersons, String customerFirstName, String customerLastName, String customerEmail, Integer customerPhoneNumber, Integer creditCardNumber) {
        this.flight = flight;
        this.numberOfPersons = numberOfPersons;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.creditCardNumber = creditCardNumber;
    }


    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Integer getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(Integer customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
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
