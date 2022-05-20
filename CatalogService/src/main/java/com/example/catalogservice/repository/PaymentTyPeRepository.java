package com.example.catalogservice.repository;

import com.example.catalogservice.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTyPeRepository extends JpaRepository<PaymentType, Integer> {
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Integer id);
}
