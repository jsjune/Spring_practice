package com.sparta.board.controller;

import com.sparta.board.domain.Board;
import com.sparta.board.domain.BoardRepository;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/api/boards")
    public List<Board> MainBoard(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

//    @GetMapping("/api/boards/write")
//
//    @PostMapping("/api/boards/write")
//
//    @GetMapping("/api/boards/{id}")
//    public Long DetailBoard(@PathVariable Long id) {
//
//    }

//    @GetMapping("/api/boards/{id}")

}
