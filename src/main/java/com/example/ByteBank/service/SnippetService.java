package com.example.ByteBank.service;


import com.example.ByteBank.models.db.Snippet;
import com.example.ByteBank.repo.SnippetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SnippetService {

    private final SnippetRepository snippetRepository;

    public Snippet createSnippet(Snippet snippet) {
        return snippetRepository.save(snippet);
    }

    public Optional<Snippet> getSnippetById(Long id) {
        return snippetRepository.findById(id);
    }

    public List<Snippet> getAllSnippets() {
        return snippetRepository.findAll();
    }

    public Snippet updateSnippet(Long id, Snippet updatedSnippet) {
        return snippetRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(updatedSnippet.getTitle());
                    existing.setContent(updatedSnippet.getContent());
                    existing.setLanguage(updatedSnippet.getLanguage());
                    existing.setTags(updatedSnippet.getTags());
                    // Update other fields as necessary
                    return snippetRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Snippet not found"));
    }

    public void deleteSnippetById(Long id) {
        snippetRepository.deleteById(id);
    }
}
