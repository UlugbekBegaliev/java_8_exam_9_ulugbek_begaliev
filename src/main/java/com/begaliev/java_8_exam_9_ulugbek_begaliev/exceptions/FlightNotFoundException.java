package com.begaliev.java_8_exam_9_ulugbek_begaliev.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(Integer flightId) {
        super("could not find ticket '" + flightId + "'.");
    }
}
