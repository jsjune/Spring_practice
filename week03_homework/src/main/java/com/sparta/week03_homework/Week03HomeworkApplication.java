package com.sparta.week03_homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week03HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week03HomeworkApplication.class, args);
    }

}
