package ru.example.job4j_github_statistics.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.example.job4j_github_statistics.model.User;
import ru.example.job4j_github_statistics.repository.UserRepository;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ScheduledTasks {
    private final RepositService repositService;
    private final GitHubRemote gitHubRemote;
    private final UserRepository userRepository;

    @Scheduled(fixedDelayString = "P1D")
    public void fetchCommits() {
        List<User> userList = userRepository.findAll();

        List<List<Map>> repositoryList = userList.stream()
                .map(u -> repositService.getRepositoryFromGitHub(u.getLogin()))
                .toList();
    }
}
