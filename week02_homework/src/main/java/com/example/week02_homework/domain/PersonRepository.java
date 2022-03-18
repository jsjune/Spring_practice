package com.example.week02_homework.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> { // id의 형태가 Long이다.
}
