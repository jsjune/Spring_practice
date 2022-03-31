package com.sparta.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommentRequestDto {
//    List<String> writer;
//    List<Integer> boardId;
    private Long boardId;
    private String writer;
    private String content;
}
