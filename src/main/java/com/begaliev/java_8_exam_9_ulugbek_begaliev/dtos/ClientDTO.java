package com.begaliev.java_8_exam_9_ulugbek_begaliev.dtos;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Client;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Ticket;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {

    private int id;
    private String fullname;
    private TicketDTO ticket;
    private int cashback;

    public static ClientDTO from(Client client){
        return ClientDTO.builder()
                .id(client.getId())
                .fullname(client.getFullname())
                .ticket(TicketDTO.from((Ticket) client.getTickets()))
                .cashback(client.getCashBack())
                .build();
    }
}

