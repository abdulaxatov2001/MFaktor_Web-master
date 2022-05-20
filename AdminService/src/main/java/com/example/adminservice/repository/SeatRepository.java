package com.example.adminservice.repository;

import com.example.adminservice.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

    List<Seat> findAllByTemplate_Id(Integer id);
}
