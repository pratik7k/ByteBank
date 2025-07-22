package com.example.ByteBank.bootstrap;



import com.example.ByteBank.models.db.Tag;
import com.example.ByteBank.repo.TagRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultTagLoader {

    private final TagRepository tagRepository;

    @PostConstruct
    public void loadDefaultTags() {
        List<String> defaultTags = List.of(
                "Java", "Spring Boot", "REST API", "Hibernate", "JPA", "MySQL", "PostgresSQL", "MongoDB",
                "HTML", "CSS", "JavaScript", "React", "Angular", "Vue", "TypeScript",
                "Node.js", "Express", "Django", "Flask", "Python", "Go", "C", "C++", "C#", "Rust",
                "Algorithms", "Data Structures", "OOP", "Functional Programming", "Design Patterns",
                "JWT", "OAuth", "Security", "Authentication", "Authorization",
                "Docker", "Kubernetes", "CI/CD", "Git", "GitHub", "DevOps",
                "Unit Testing", "JUnit", "Mockito", "Logging", "Exception Handling", "Multithreading",
                "Microservices", "Monolith", "Event-Driven", "WebSockets",
                "AI", "ML", "Deep Learning", "NLP", "OpenAI", "TensorFlow", "PyTorch",
                "VS Code", "IntelliJ", "Terminal", "Linux", "Bash", "Windows", "MacOS","WebSocket", "GraphQL", "Encryption", "Security", "Regex", "Unicode", "DOM", "API Gateway", "i18n", "l10n",
                "Hashing", "Docker Compose", "Kubernetes", "Helm", "OWASP", "Session Management", "Database Migration",
                "CI/CD", "GitHub Actions", "DevOps", "Test Automation", "Data Structures", "Multithreading",
                "Concurrency", "Parallelism", "WebAssembly", "Tailwind", "SASS", "Styled Components", "Accessibility",
                "Form Validation", "Serverless", "Lambda", "Microservices", "Monorepo", "TDD", "BDD", "State Management",
                "Code Review", "Observability", "Tracing", "Logging", "Profiling", "Benchmarking", "Caching"

        );

        defaultTags.forEach(tagName -> {
            if (!tagRepository.existsByNameIgnoreCase(tagName)) {
                Tag tag = Tag.builder()
                        .name(tagName)
                        .build();
                tagRepository.save(tag);
            }
        });

        System.out.println("✅ Default tags loaded.");
    }
}
