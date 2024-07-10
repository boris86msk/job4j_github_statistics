package ru.example.job4j_github_statistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.job4j_github_statistics.model.Repository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Repository, Long> {
    List<Repository> findRepositoryByUserId(Long user_id);
}
