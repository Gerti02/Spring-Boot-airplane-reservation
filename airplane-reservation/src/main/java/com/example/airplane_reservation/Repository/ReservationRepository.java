package com.example.airplane_reservation.Repository;

import com.example.airplane_reservation.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
