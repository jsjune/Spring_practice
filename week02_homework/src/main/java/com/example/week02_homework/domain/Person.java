package com.example.week02_homework.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // Getter 메소드 생략가능
@NoArgsConstructor
@Entity // 테이블임을 나타낸다.
public class Person extends  Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령이다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타낸다.
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String job;

    public Person(PersonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age= requestDto.getAge();
        this.job = requestDto.getJob();
    }

    public void update(PersonRequestDto requestDto) {
        this.name=requestDto.getName();
        this.age=requestDto.getAge();
        this.job=requestDto.getJob();
    }


}
