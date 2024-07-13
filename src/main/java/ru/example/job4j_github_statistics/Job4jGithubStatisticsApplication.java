package ru.example.job4j_github_statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Job4jGithubStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Job4jGithubStatisticsApplication.class, args);
    }

}
