package ru.example.job4j_github_statistics.dto.commit;

import lombok.Data;

@Data
public class Parent {
    private String sha;
    private String url;
    private String html_url;
}
