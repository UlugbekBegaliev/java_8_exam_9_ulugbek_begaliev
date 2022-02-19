package com.begaliev.java_8_exam_9_ulugbek_begaliev.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightId")
    private Integer id;

    @Column(name = "cost")
    private double cost;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "destination")
    private String finishPoint;

    @Column(name = "beginning")
    private String startPoint;

    @Enumerated(EnumType.STRING)
    private AirTransport transport;

    @Column(name = "departure")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date timeToStart;

    @Column(name = "arrival")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date timeToFinish;

    @Column(name = "places")
    private int countPlaces ;

    @Column(columnDefinition = "boolean default true")
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Ticket> tickets;
}
