package ru.example.job4j_github_statistics.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.example.job4j_github_statistics.model.Repository;
import ru.example.job4j_github_statistics.model.User;
import ru.example.job4j_github_statistics.repository.ApplicationRepository;
import ru.example.job4j_github_statistics.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ScheduledTasks {
    private final RepositService repositService;
    private final GitHubRemote gitHubRemote;
    private final UserRepository userRepository;
    private final ApplicationRepository appRepository;

    /**
     * "P1D" - the working period is once a one day
     */
    @Scheduled(fixedDelayString = "P1D")
    public void fetchCommits() {
        List<User> userList = userRepository.findAll();

        for (User user : userList) {
            List<Map> repositoryFromGitHub = repositService.getRepositoryFromGitHub(user.getLogin());
            List<Long> listGitHubId = repositoryFromGitHub.stream()
                    .map(r -> (Long) r.get("id"))
                    .toList();

            List<Repository> repositoryFromDB = appRepository.findRepositoryByUserId(user.getId());
            List<Long> listGitHubIdFromDB = repositoryFromDB.stream()
                    .map(r -> r.getGitHudId())
                    .toList();

            for (Long gitHubID : listGitHubId) {
                if (!listGitHubIdFromDB.contains(gitHubID)) {
                    Optional<Map> mapById = repositoryFromGitHub.stream()
                            .filter(r -> Objects.equals(r.get("id"), gitHubID))
                            .findFirst();
                    Repository repo = new Repository();
                    if(mapById.isPresent()) {
                        Map map = mapById.get();
                        repo.setGitHudId(Long.parseLong(map.get("id").toString()));
                        repo.setUrl(map.get("html_url").toString());
                        repo.setCreatedAt(LocalDateTime.parse(map.get("created_at").toString().substring(0, 19)));
                        repo.setPushedAt(LocalDateTime.parse(map.get("pushed_at").toString().substring(0, 19)));
                        repo.setUser((User) map.get("user"));
                    }
                    appRepository.save(repo);
                }
            }
        }
    }
}
