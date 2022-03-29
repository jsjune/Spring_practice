package com.sparta.board.domain;

import com.sparta.board.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private Long BoardId;

    public Comment(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.writer = requestDto.getWriter();
        this.BoardId = requestDto.getBoardId();
    }
}
