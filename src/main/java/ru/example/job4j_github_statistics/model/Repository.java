package ru.example.job4j_github_statistics.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "repositories")
public class Repository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "git_hud_id")
    private Long gitHudId;
    private String url;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "pushed_at")
    private LocalDateTime pushedAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
