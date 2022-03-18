package com.example.week02_homework.controller;

import com.example.week02_homework.domain.Person;
import com.example.week02_homework.domain.PersonRepository;
import com.example.week02_homework.domain.PersonRequestDto;
import com.example.week02_homework.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping("/myinfo")
    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    @PostMapping("/myinfo/people")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미한다.
        // 사람의 정보를 만들기 위해서는 그 사람 이름과 직업이 필요한데 그 정보를 가져오는 녀석
        // 저장하는 것은 Dto가 아니라 Person이니, Dto의 정보를 person에 담아야 한다.
        Person person = new Person(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환한다.
        return personRepository.save(person);
    }

    @PutMapping("/myinfo/people/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return personService.update(id, requestDto);
    }

    @DeleteMapping("/myinfo/people/{id}")
    public Long deletePerson(@PathVariable long id) {
        personRepository.deleteById(id);
        return id;
    }
}
