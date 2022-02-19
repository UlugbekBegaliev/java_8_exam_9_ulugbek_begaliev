package com.begaliev.java_8_exam_9_ulugbek_begaliev.repositories;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    public Ticket findTicketsById(Integer id);

    public List<Ticket> findByReservedFalse();

    public List<Ticket> findByCostBetween(Double from, Double to);

    public List<Ticket> findByTimeToStartBetween(Date from, Date to);
}
