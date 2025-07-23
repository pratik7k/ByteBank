package com.example.ByteBank.repo;

import com.example.ByteBank.models.db.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, String> {
    boolean existsByNameIgnoreCase(String name);
    boolean existsBySlug(String slug);
    Optional<Tag> findByNameIgnoreCase(String name);
}

