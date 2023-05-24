package com.schlueter.flyaway.service;

public class PaymentException extends Exception {
    private int fligtId;

    public PaymentException(String message) {
        super(message);
    }

    public PaymentException(String message, int fligtId) {
        super(message);
        this.fligtId = fligtId;
    }

    public int getFligtId() {
        return fligtId;
    }

    public void setFligtId(int fligtId) {
        this.fligtId = fligtId;
    }

}

