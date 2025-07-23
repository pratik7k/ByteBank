package com.example.ByteBank.service;

import com.example.ByteBank.models.db.Tag;

import com.example.ByteBank.repo.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public String generateUniqueSlug(String name) {
        String baseSlug = name.trim().toLowerCase().replaceAll("[^a-z0-9]+", "-");
        String slug = baseSlug;
        int counter = 1;
        while (tagRepository.existsBySlug(slug)) {
            slug = baseSlug + "-" + counter++;
        }
        return slug;
    }

    @Transactional
    public void createTag(String name) {
        tagRepository.findByNameIgnoreCase(name)
                .orElseGet(() -> {
                    String slug = generateUniqueSlug(name);
                    Tag newTag = Tag.builder().name(name).slug(slug).build();
                    return tagRepository.save(newTag);
                });
    }
}
