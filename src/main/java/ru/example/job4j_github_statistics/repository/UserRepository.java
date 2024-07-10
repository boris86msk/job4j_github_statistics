package ru.example.job4j_github_statistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.job4j_github_statistics.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String login);
}
