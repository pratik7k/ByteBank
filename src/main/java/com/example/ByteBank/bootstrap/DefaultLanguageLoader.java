package com.example.ByteBank.bootstrap;

import com.example.ByteBank.models.db.Language;
import com.example.ByteBank.repo.LanguageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultLanguageLoader {

    private final LanguageRepository languageRepository;

    @PostConstruct
    public void loadDefaultLanguages() {
        List<String> defaultLanguages = List.of(
                "Java", "Python", "JavaScript", "TypeScript", "C", "C++", "C#", "Go", "Rust", "Ruby",
                "Kotlin", "Swift", "PHP", "Scala", "Haskell", "Perl", "Dart", "Elixir",
                "R", "Lua", "Shell", "Bash",
                "PowerShell", "Objective-C", "Groovy", "F#", "Assembly", "Erlang", "Julia", "MATLAB", "Nim",
                "Crystal", "V", "Zig", "Red",
                "PureScript", "Idris", "ReScript", "Futhark", "Erlang", "OCaml", "Agda",
                "Haxe", "Tcl", "Dart", "Smalltalk", "Janet", "Ballerina",
                "Ring", "Io", "ATS", "F*", "ReasonML", "Wolfram", "Quorum", "Racket", "Pony", "Pharo", "Hack",
                "Neko", "Nix", "Koka", "Pike", "Seed7", "COBOL", "Fortran",
                "Ada", "Vala", "Modula-2", "Algol", "J", "K", "ML", "CLIPS", "Xojo", "ZPL", "Lily", "Chapel",
                "Markdown", "reStructuredText", "AsciiDoc", "Textile", "Org-mode", "LaTeX",
                "RST", "CommonMark", "Pandoc", "Sphinx", "Doxygen", "DocBook", "Javadoc", "Swagger",
                "OpenAPI", "RAML", "API Blueprint", "YAML", "TOML", "JSON", "INI", "XML", "HTML", "XHTML",
                "BBCode", "Creole", "HAML", "Pug", "Slim", "Mustache", "Handlebars", "Liquid", "EJS", "Jinja",
                "RMarkdown", "Gemtext"

        );

        defaultLanguages.forEach(langName -> {
            if (!languageRepository.existsByNameIgnoreCase(langName)) {
                Language language = Language.builder()
                        .name(langName)
                        .build();
                languageRepository.save(language);
            }
        });

        System.out.println("✅ Default languages loaded.");
    }
}
