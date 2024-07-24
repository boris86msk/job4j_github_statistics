package ru.example.job4j_github_statistics.dto.commit;

import lombok.Data;

@Data
public class Verification {
    private boolean verified;
    private String reason;
    private Object signature;
    private Object payload;
}
