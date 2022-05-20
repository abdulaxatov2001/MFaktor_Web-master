package com.example.catalogservice.repository;

import com.example.catalogservice.entity.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Integer> {
}
