package com.example.catalogservice.repository;

import com.example.catalogservice.entity.AdsSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdsSourceRepository extends JpaRepository<AdsSource, Integer> {
    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Integer id);

    Optional<AdsSource> findByName(String name);

}
