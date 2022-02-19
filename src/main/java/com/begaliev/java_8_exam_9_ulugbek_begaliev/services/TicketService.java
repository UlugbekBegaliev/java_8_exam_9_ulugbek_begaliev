package com.begaliev.java_8_exam_9_ulugbek_begaliev.services;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Ticket;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public void saveTicket(Ticket ticket) {
        if (checkNotNull(ticket)) {
            ticketRepository.save(ticket);
        }
    }

    static <T> boolean checkNotNull(T obj) {
        return (obj != null);
    }


    public List<Ticket> fndAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findById(Integer ticketId) {
        return ticketRepository.findById(ticketId);
    }

    public Ticket findTicketById(Integer ticketId) {
        return ticketRepository.findTicketsById(ticketId);
    }

    public List<Ticket> findAllUnreservedTickets() {
        List<Ticket> tickets = ticketRepository.findByReservedFalse();

        return tickets;
    }

    public List<Ticket> findCostBetween(Double from, Double to) {

        return ticketRepository.findByCostBetween(from, to);
    }
}
