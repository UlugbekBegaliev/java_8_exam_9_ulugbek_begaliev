package com.begaliev.java_8_exam_9_ulugbek_begaliev.services;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Flight;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.repositories.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public Flight findFlightById(Integer flightId){
        return flightRepository.findFlightById(flightId);
    }

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }
}
