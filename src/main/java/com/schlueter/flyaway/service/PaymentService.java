package com.schlueter.flyaway.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public boolean conductPayment(Double amount, Integer creditCardNumber) throws PaymentException {
        if(creditCardNumber % 2 != 0) {
            return true;
        } else {
            throw new PaymentException("Payment failed");
        }
    }
}
