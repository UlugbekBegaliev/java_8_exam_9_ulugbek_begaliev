package com.begaliev.java_8_exam_9_ulugbek_begaliev.services;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Client;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client findClientById(Integer id){
        return clientRepository.findClientById(id);
    }

    public void saveClient(Client client){
        clientRepository.save(client);
    }

}
