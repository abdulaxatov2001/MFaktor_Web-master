package com.example.catalogservice.repository;

import com.example.catalogservice.entity.EventType;
import com.example.catalogservice.entity.PaymentColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentColorRepository extends JpaRepository<PaymentColor, Integer> {
    boolean existsByName(String name);
    boolean existsByCode(String code);
    boolean existsByNameAndIdNot(String name, Integer id);
    boolean existsByCodeAndIdNot(String code, Integer id);
}
