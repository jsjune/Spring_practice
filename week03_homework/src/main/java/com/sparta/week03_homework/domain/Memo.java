package com.sparta.week03_homework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Memo extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(MemoRequestDto memoRequestDto) {
        this.username= memoRequestDto.getUsername();
        this.contents= memoRequestDto.getContents();
    }

    public void update(MemoRequestDto memoRequestDto) {
        this.username= memoRequestDto.getUsername();
        this.contents= memoRequestDto.getContents();
    }
}
