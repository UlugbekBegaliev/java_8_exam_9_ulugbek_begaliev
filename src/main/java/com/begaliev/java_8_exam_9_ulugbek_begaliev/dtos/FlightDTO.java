package com.begaliev.java_8_exam_9_ulugbek_begaliev.dtos;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.AirTransport;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Flight;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Ticket;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class FlightDTO {

    private int id;
    private double cost;
    private String companyName;
    private String finishPoint;
    private String startPoint;
    private AirTransport transport;
    private Date timeToStart;
    private Date timeToFinish;
    private int countPlaces ;
    private TicketDTO tickets;
    private CompanyDTO company;

    public static FlightDTO from(Flight flight){
        return FlightDTO.builder()
                .id(flight.getId())
                .cost(flight.getCost())
                .companyName(flight.getCompanyName())
                .finishPoint(flight.getFinishPoint())
                .startPoint(flight.getStartPoint())
                .transport(flight.getTransport())
                .timeToStart(flight.getTimeToStart())
                .timeToFinish(flight.getTimeToFinish())
                .countPlaces(flight.getCountPlaces())
                .tickets(TicketDTO.from((Ticket) flight.getTickets()))
                .build();
    }
}