package ru.example.job4j_github_statistics.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "commits")
public class Commit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String author;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "repository_id")
    private Repository repository;
}
