package com.begaliev.java_8_exam_9_ulugbek_begaliev.dtos;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Ticket;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class TicketDTO {

    private int id;
    private double cost;
    private String companyName;
    private String finishPoint;
    private String startPoint;
    private Date timeToStart;
    private Date timeToFinish;
    private ClientDTO client;
    private FlightDTO flight;

    public static TicketDTO from(Ticket ticket){
        return TicketDTO.builder()
                .id(ticket.getId())
                .cost(ticket.getCost())
                .finishPoint(ticket.getFinishPoint())
                .startPoint(ticket.getStartPoint())
                .timeToStart(ticket.getTimeToStart())
                .timeToFinish(ticket.getTimeToFinish())
                .client(ClientDTO.from(ticket.getClient()))
                .flight(FlightDTO.from(ticket.getFlight()))
                .build();
    }

}