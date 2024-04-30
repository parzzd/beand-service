package com.hampcode.bankingservice.repository;

import com.hampcode.bankingservice.model.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findByArticleTitle(String articleTitle);
}
