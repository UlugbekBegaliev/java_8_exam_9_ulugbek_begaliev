package com.begaliev.java_8_exam_9_ulugbek_begaliev.services;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.dtos.CompanyDTO;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.exceptions.CompanyAlreadyRegisteredException;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.exceptions.CompanyNotFoundException;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Company;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.CompanyRegisterForm;
import com.begaliev.java_8_exam_9_ulugbek_begaliev.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final PasswordEncoder encoder;

    public Page<CompanyDTO> getAll(Pageable pageable){
        return companyRepository.findAll(pageable).map(CompanyDTO::from);
    }

    public CompanyDTO register(CompanyRegisterForm form) {
        if (companyRepository.existsByEmail(form.getEmail())){
            throw new CompanyAlreadyRegisteredException();
        }

        var user = Company.builder()
                .email(form.getEmail())
                .companyName(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        return CompanyDTO.from(user);
    }

    public CompanyDTO getByEmail(String email) {
        var user = companyRepository.findByEmail(email)
                .orElseThrow(CompanyNotFoundException::new);

        return CompanyDTO.from(user);
    }

    public boolean existsByEmail(String email){
        return companyRepository.existsByEmail(email);
    }

    public void add(Company company) {
        companyRepository.findByEmail(company.getEmail());
    }
}
