package ru.example.job4j_github_statistics.dto.commit;

import lombok.Data;

@Data
public class Commit {
    private Author author;
    private Committer committer;
    private String message;
    private Tree tree;
    private String url;
    private int comment_count;
    private Verification verification;
}
