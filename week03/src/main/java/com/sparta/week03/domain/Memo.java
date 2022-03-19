package com.sparta.week03.domain;

import com.sparta.week03.domain.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만든다.
@Getter // getter를 만든다.
@Entity // 테이블과 연계됨을 스프링에게 알려준다.
public class Memo extends Timestamped {  // 생성, 수정 시간을 자동으로 만들어 준다.

    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령
    @Id // ID 값, primary key로 사용하겠다는 뜻
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(String username, String contents) {
        this.username = username;
        this.contents = contents;
    }

    // 테이블의 한 행
    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
