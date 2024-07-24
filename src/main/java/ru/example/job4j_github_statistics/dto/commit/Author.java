package ru.example.job4j_github_statistics.dto.commit;

import lombok.Data;

@Data
public class Author {
    private String name;
    private String email;
    private String date;
}
