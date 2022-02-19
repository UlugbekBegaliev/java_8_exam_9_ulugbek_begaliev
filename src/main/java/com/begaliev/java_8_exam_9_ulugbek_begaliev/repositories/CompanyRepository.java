package com.begaliev.java_8_exam_9_ulugbek_begaliev.repositories;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findByEmail(String email);

    boolean existsByEmail(String email);
}
