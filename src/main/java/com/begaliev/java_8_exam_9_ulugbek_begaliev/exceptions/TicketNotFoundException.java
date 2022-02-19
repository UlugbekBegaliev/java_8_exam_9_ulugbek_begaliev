package com.begaliev.java_8_exam_9_ulugbek_begaliev.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException(Integer ticketId) {
        super("could not find ticket '" + ticketId + "'.");
    }
}
