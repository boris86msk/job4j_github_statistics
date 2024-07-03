package ru.example.job4j_github_statistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.job4j_github_statistics.dto.RepositoryCommits;
import ru.example.job4j_github_statistics.model.Repository;
import ru.example.job4j_github_statistics.service.RepositoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GitHubController {

    @Autowired
    private RepositoryService repositoryService;

    @GetMapping("/repositories")
    public List<Repository> getAllRepositories() {
        return List.of();
    }

    @GetMapping("/commits/{name}")
    public List<RepositoryCommits> getCommits(@PathVariable(value = "name") String name) {
        return List.of();
    }

    @PostMapping("/repository")
    public ResponseEntity<Void> create(@RequestBody Repository repository) {
        repositoryService.create(repository);
        return ResponseEntity.noContent().build();
    }
}
