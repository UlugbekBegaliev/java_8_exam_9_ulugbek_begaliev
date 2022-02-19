package com.begaliev.java_8_exam_9_ulugbek_begaliev.repositories;

import com.begaliev.java_8_exam_9_ulugbek_begaliev.models.PasswordManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordManagerRepository extends JpaRepository<PasswordManager, Integer> {

    boolean existsByToken(String token);

    Optional<PasswordManager> findByToken(String token);

    void deleteAll();
}
