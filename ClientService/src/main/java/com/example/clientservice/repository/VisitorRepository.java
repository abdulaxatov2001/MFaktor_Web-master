package com.example.clientservice.repository;

import com.example.clientservice.entity.Payment;
import com.example.clientservice.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Long id);

    Optional<Visitor> findByPhoneNumber(String phone);
}
