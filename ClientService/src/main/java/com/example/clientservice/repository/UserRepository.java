package com.example.clientservice.repository;

import com.example.clientservice.entity.Payment;
import com.example.clientservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByPhoneNumber(String phoneNumber);

    List<User> findAllByChatIdNotNull();

    Optional<User> findByChatId(Long id);
}
