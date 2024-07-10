package ru.example.job4j_github_statistics.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.job4j_github_statistics.dto.RepositoryCommits;
import ru.example.job4j_github_statistics.model.Repository;
import ru.example.job4j_github_statistics.service.RepositService;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GitHubController {

    private final RepositService repositService;

    @GetMapping("/repositories/{username}")
    public List<Repository> getAllRepositories(@PathVariable String username) {
        return repositService.getList(username);
    }

    @GetMapping("/commits/{name}")
    public List<RepositoryCommits> getCommits(@PathVariable(value = "name") String name) {
        return List.of();
    }

//    @PostMapping("/repository")
//    public ResponseEntity<Void> create(@RequestBody Repository repository) {
//        repositService.create(repository);
//        return ResponseEntity.noContent().build();
//    }
}
