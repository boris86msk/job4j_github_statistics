package ru.example.job4j_github_statistics.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "Получить все репозитории пользователя",
            description = "Если пользователь сохранен в системе, возвращает лист репозиториев из БД." +
                    " В противном случаи автоматически добавляет нового пользователя, загружает и сохраняет репозитории")
    @GetMapping("/repositories/{username}")
    public List<Repository> getAllRepositories(@PathVariable String username) {
            return repositService.getListRepository(username);
    }

    @Operation(
            summary = "Все коммиты репозитория",
            description = "Возвращает список коммитов для конкретного репозитория")
    @GetMapping("/commits/{owner}/{repo}")
    public List<Commit> getCommits(@PathVariable(value = "owner") String owner,
                                   @PathVariable(value = "repo") String repo) {
        return repositService.getListCommit(owner, repo);
    }

    @Operation(
            summary = "Часть коммитов репозитория",
            description = "Возвращает список коммитов репозитория, начиная от указанного (Sha)")
    @GetMapping("commits/{owner}/{repo}/{sha}")
    public List<Commit> getListCommitWithSha(@PathVariable(value = "owner") String owner,
                                             @PathVariable(value = "repo") String repo,
                                             @PathVariable(value = "sha") String sha) {
        return repositService.getListCommitStartWithSha(owner, repo, sha);
    }

}
