package com.example.week02_homework.service;


import com.example.week02_homework.domain.Person;
import com.example.week02_homework.domain.PersonRepository;
import com.example.week02_homework.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // ?
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class PersonService {

    // final : 서비스에게 꼭 필요한 녀석임을 명시
    private final PersonRepository personRepository;

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, PersonRequestDto requestDto) {
        Person p = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        p.update(requestDto);
        return p.getId();
    }
}
