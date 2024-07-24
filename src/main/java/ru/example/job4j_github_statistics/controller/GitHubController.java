package ru.example.job4j_github_statistics.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.job4j_github_statistics.model.Commit;
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
            return repositService.getListRepository(username);
    }

    @GetMapping("/commits/{owner}/{repo}")
    public List<Commit> getCommits(@PathVariable(value = "owner") String owner,
                                   @PathVariable(value = "repo") String repo) {
        return repositService.getListCommit(owner, repo);
    }

}
