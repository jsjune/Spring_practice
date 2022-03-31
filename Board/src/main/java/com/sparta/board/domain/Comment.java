package com.sparta.board.domain;

import com.sparta.board.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @ManyToOne
//    @JoinColumn(name="BOARD_ID",nullable = false)
    @Column(nullable = false)
    private Long board;

    @Column(nullable = false)
    private String content;


    @Column(nullable = false)
    private String writer;

    public Comment(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.writer = requestDto.getWriter();
        this.board = requestDto.getBoardId();
    }
}
