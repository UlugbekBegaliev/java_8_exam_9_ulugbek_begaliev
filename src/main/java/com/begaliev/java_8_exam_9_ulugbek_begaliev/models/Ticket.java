package com.begaliev.java_8_exam_9_ulugbek_begaliev.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cost")
    private double cost;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "destination")
    private String finishPoint;

    @Column(name = "beginning")
    private String startPoint;

    @Column(name = "reserved")
    private Boolean reserved;

    @Column(name = "buy")
    private Boolean buy;

    @Column(name = "departure")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date timeToStart;

    @Column(name = "arrival")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date timeToFinish;
}
