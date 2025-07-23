package com.example.ByteBank.repo;


import com.example.ByteBank.models.db.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnippetRepository extends JpaRepository<Snippet, Long> {
    // Add custom query methods if needed later
}
