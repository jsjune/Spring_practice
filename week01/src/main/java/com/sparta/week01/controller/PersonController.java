package com.sparta.week01.controller;

import com.sparta.week01.prac.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getPeople() {
        Person person = new Person();
        person.setName("나");
        person.setAge(28);
        person.setJob("백수");
        return person;
    }

}
