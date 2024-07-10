package ru.example.job4j_github_statistics.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ScheduledTasks {
    private final RepositService repositoryService;
    private final GitHubRemote gitHubRemote;

    public void fetchCommits() {

    }
}
