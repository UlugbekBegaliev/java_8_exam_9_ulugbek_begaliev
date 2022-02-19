package com.begaliev.java_8_exam_9_ulugbek_begaliev.services;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.exceptions.CompanyNotFoundException;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Company;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.PasswordManager;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.repositories.CompanyRepository;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.repositories.PasswordManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PasswordManagerService {

    private final PasswordManagerRepository passwordManagerRepository;
    private final CompanyRepository companyRepository;

    public void createToken(String email){

        Company company = companyRepository.findByEmail(email)
                .orElseThrow(CompanyNotFoundException::new);
        PasswordManager token = PasswordManager.builder()
                .company(company)
                .token(UUID.randomUUID().toString())
                .build();

        passwordManagerRepository.deleteAll();
        passwordManagerRepository.save(token);

        emailService.sendSimpleMessage(customer.getEmail(),
                "onlineshop | Password Recovery", "Token: " + token.getToken());
    }

    public boolean existsByToken(String token){
        return passwordManagerRepository.existsByToken(token);
    }
}
