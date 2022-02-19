package com.begaliev.java_8_exam_9_ulugbek_begaliev.repositories;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    public Client findClientById(Integer id);
}
