package com.example.adminservice.repository;

import com.example.adminservice.entity.Speaker;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerRepository extends JpaRepository<Speaker, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
    List<Speaker> findAllByActive(boolean active);

    List<Speaker> findAllByActive(boolean active, Pageable pageable);
}
