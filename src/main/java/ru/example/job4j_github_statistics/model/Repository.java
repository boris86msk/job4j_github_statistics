package ru.example.job4j_github_statistics.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "repositories")
public class Repository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
}
