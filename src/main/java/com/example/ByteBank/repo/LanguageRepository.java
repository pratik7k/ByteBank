package com.example.ByteBank.repo;

import com.example.ByteBank.models.db.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    boolean existsByNameIgnoreCase(String name);
}
