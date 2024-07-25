package ru.example.job4j_github_statistics.dto;

import lombok.Data;

@Data
public class CommitResponse {
    private String sha;

    private String nodeId;

    private Commit commit;
}

