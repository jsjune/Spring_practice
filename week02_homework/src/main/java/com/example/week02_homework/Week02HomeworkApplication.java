package com.example.week02_homework;

import com.example.week02_homework.domain.Person;
import com.example.week02_homework.domain.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // ?
@SpringBootApplication
public class Week02HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week02HomeworkApplication.class, args);
    }

    // JPA 실행 코드
//    @Bean //?
//    public CommandLineRunner demo(PersonRepository personRepository) {
//        return (args) ->{
//            personRepository.save(new Person("나", 29,"백수"));
//        };
//    }

}
