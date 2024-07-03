package ru.example.job4j_github_statistics.service;

import org.springframework.stereotype.Service;
import ru.example.job4j_github_statistics.model.Commit;
import ru.example.job4j_github_statistics.model.Repository;

import java.util.List;

@Service
public class GitHubService {

    public List<Repository> fetchRepositories(String username) {
        return List.of();
    }

    public List<Commit> fetchCommits(String repository) {
        return List.of();
    }
}