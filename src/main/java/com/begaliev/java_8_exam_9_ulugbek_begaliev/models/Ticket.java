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
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cost")
    private double cost;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flightId")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private List<Company> companies;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((companies == null) ? 0 : companies.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        if (companies == null) {
            if (other.companies != null) {
                return false;
            }
        } else if (!companies.equals(other.companies)) {
            return false;
        }
        return true;
    }
}
