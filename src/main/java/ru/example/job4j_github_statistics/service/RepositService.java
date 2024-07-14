package ru.example.job4j_github_statistics.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.example.job4j_github_statistics.model.Repository;
import ru.example.job4j_github_statistics.model.User;
import ru.example.job4j_github_statistics.repository.ApplicationRepository;
import ru.example.job4j_github_statistics.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RepositService {

    private final WebClient webClient;
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public List<Repository> getList(String username) {
        Optional<User> userByLogin = userRepository.findUserByLogin(username);

        if (userByLogin.isPresent()) {
            return applicationRepository.findRepositoryByUserId(userByLogin.get().getId());
        } else {
            List<Map> repository = getRepositoryFromGitHub(username);

            User newUser = new User();
            newUser.setLogin(username);
            userRepository.save(newUser);

            List<Repository> repositoryList = repository.stream()
                    .map(t -> {
                        Repository repo = new Repository();
                        repo.setId(Long.parseLong(t.get("id").toString()));
                        repo.setUrl(t.get("html_url").toString());
                        repo.setCreatedAt(LocalDateTime.parse(t.get("created_at").toString().substring(0, 19)));
                        repo.setPushedAt(LocalDateTime.parse(t.get("pushed_at").toString().substring(0, 19)));
                        repo.setUser(newUser);
                        return repo;
                    })
                    .toList();

            applicationRepository.saveAll(repositoryList);

            return repositoryList;
        }
    }

    public List<Map> getRepositoryFromGitHub(String login) {
        String request = String.format("https://api.github.com/users/%s/repos", login);
        return webClient
                .get()
                .uri(request)
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }
}
