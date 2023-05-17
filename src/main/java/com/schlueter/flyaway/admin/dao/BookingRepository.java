package com.schlueter.flyaway.dao;

import com.schlueter.flyaway.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BookingRepository extends JpaRepository<Booking, Long> {
        @Query("SELECT b.id AS bookingNumber, c.firstName, " +
                "c.lastName, b.numberOfPersons, a1.name AS sourceAirport," +
                " a2.name AS destinationAirport, " +
                "f.departureDateTime AS flightDate, " +
                "(b.numberOfPersons * f.ticketPrice) AS totalPrice " +
                "FROM Booking b " +
                "JOIN b.customer c " +
                "JOIN b.flight f " +
                "JOIN f.sourceAirport a1 " +
                "JOIN f.destinationAirport a2 " +
                "WHERE b.id = :bookingNumber")
        BookingInfoProjection findBookingInfoByBookingNumber(@Param("bookingNumber") Long bookingNumber);

        /*@Query("SELECT b.id AS bookingNumber, c.firstName, " +
                "c.lastName, b.numberOfPersons, a1.name AS sourceAirport," +
                " a2.name AS destinationAirport, " +
                "f.departureDateTime AS flightDate, " +
                "(b.numberOfPersons * f.ticketPrice) AS totalPrice " +
                "FROM Booking b " +
                "JOIN b.customer c " +
                "JOIN b.flight f " +
                "JOIN f.sourceAirport a1 " +
                "JOIN f.destinationAirport a2 " +
                "WHERE b.id = :bookingNumber")
        BookingInfoProjection findBookingInfoByBookingNumber(@Param("bookingNumber") Long bookingNumber);*/

        @Modifying
        @Query("DELETE FROM Booking b WHERE b.customer.id = :customerId")
        void deleteBookingsByCustomerId(@Param("customerId") Long customerId);
}



