package ru.example.job4j_github_statistics.dto.commit;

import lombok.Data;

import java.util.List;

@Data
public class CommitResponse {
    private String sha;
    private String node_id;
    private Commit commit;
    private String url;
    private String html_url;
    private String comments_url;
    private Author author;
    private Committer committer;
    private List<Parent> parents;
}
