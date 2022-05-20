package com.example.adminservice.repository;

import com.example.adminservice.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TemplateRepository extends JpaRepository<Template, Integer> {

    Optional<Template> findByName(String name);
}
