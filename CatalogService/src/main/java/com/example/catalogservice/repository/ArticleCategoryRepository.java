package com.example.catalogservice.repository;

import com.example.catalogservice.entity.ArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, Integer> {
    Optional<ArticleCategory> findByName(String name);
}
