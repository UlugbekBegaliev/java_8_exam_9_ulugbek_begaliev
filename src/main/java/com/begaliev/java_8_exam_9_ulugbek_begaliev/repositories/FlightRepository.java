package com.begaliev.java_8_exam_9_ulugbek_begaliev.repositories;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findFlightById(Integer flightId);
}
