package com.schlueter.flyaway.service;

import com.schlueter.flyaway.dao.BookingRepository;
import com.schlueter.flyaway.entity.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{
    private BookingRepository bookingRepository;

    public  BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found - " + id));
    }

    @Override
    public void deleteById(long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Booking save(Booking booking) {
        if(booking.getNumberOfPersons() < 1) {
            throw new RuntimeException("The number of persons in a booking has to be larger than 1.");
        }
        return bookingRepository.save(booking);
    }
}
