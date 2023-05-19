package com.schlueter.flyaway.dao;

import com.schlueter.flyaway.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Modifying
    @Query("DELETE FROM Flight f WHERE f.airline.id = :airlineId")
    void deleteFlightsByAirlineId(@Param("airlineId") Long airlineId);

    @Modifying
    @Query("DELETE FROM Flight f WHERE f.sourceAirport.id = :airportId OR f.destinationAirport.id = :airportId")
    void deleteFlightsByAirportId(@Param("airportId") Long airportId);

    @Query("SELECT f FROM Flight f WHERE f.airline.shortName = :airlineShortName")
    List<Flight> findByAirlineShortName(@Param("airlineShortName") String airlineShortName);
}

