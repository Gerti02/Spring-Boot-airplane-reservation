package com.example.airplane_reservation.Repository;

import com.example.airplane_reservation.Model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flights, Long> {
}
