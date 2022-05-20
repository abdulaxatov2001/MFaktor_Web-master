package com.example.clientservice.repository;

import com.example.clientservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findAllByUserId(Long user_id);
}
