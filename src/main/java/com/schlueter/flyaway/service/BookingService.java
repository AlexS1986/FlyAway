package com.schlueter.flyaway.service;

import com.schlueter.flyaway.entity.Booking;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookingService {
    List<Booking> findAll();

    Booking findById(long id);

    @Transactional
    void deleteById(long id);

    @Transactional
    Booking save(Booking booking);
    
}
