package com.begaliev.java_8_exam_9_ulugbek_begaliev.controllers;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.services.ClientService;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.services.FlightService;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final TicketService ticketService;
    private final ClientService clientService;
    private final FlightService flightService;
}
