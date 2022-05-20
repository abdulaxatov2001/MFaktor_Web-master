package com.example.catalogservice.repository;

import com.example.catalogservice.entity.EventType;
import com.example.catalogservice.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
