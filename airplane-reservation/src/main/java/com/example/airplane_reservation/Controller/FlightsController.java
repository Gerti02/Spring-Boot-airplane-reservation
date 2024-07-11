package com.example.airplane_reservation.Controller;

import com.example.airplane_reservation.Model.Flights;
import com.example.airplane_reservation.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightsController {

    private final FlightRepository flightsRepository;

    @Autowired
    public FlightsController(FlightRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    @GetMapping
    public ResponseEntity<List<Flights>> getAllFlights() {
        List<Flights> flights = flightsRepository.findAll();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flights> getFlightById(@PathVariable("id") Long id) {
        Optional<Flights> flightOptional = flightsRepository.findById(id);
        return flightOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Flights> createFlight(@RequestBody Flights flight) {
        Flights savedFlight = flightsRepository.save(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flights> updateFlight(@PathVariable("id") Long id, @RequestBody Flights flight) {
        if (!flightsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        flight.setId(id);
        Flights updatedFlight = flightsRepository.save(flight);
        return ResponseEntity.ok(updatedFlight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable("id") Long id) {
        if (!flightsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        flightsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
