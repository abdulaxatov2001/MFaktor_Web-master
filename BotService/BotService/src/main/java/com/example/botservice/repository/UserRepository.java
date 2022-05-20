package com.example.botservice.repository;

import com.example.botservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByPhoneNumber(String phoneNumber);

    List<User> findAllByChatIdIsNotNull();

    Optional<User> findByChatId(String id);
}
