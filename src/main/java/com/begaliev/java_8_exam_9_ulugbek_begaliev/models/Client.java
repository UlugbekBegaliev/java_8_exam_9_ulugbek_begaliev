package com.begaliev.java_8_exam_9_ulugbek_begaliev.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientId")
    private Integer id;

    @Column(name = "fio_client")
    private String fio_client;

    @Column(name = "locked",columnDefinition = "boolean default true")
    private Boolean isLocked  ;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Ticket> tickets;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fio_client == null) ? 0 : fio_client.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Client other = (Client) obj;
        if (fio_client == null) {
            if (other.fio_client != null)
                return false;
        } else if (!fio_client.equals(other.fio_client))
            return false;
        return true;
    }
}