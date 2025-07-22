package com.example.ByteBank.models.db;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "slug", nullable = false, unique = true)
    private String slug;

    // Optional: reverse mapping (only needed if you want to query Tag → Snippets)
    @ManyToMany(mappedBy = "tags")
    private Set<Snippet> snippets = new HashSet<>();

    @PrePersist
    public void generateSlug() {
        if (this.slug == null && this.name != null) {
            this.slug = name.trim().toLowerCase().replaceAll("[^a-z0-9]+", "-");
        }
    }
}
