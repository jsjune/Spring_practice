package com.sparta.board.controller;

import com.sparta.board.domain.Board;
import com.sparta.board.domain.BoardDto;
import com.sparta.board.domain.BoardRepository;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/api/boards") // 전체 게시글 목록으로 보여주기
    public List<Board> MainBoard(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/boards") // 게시글 작성
    public Board createBoard(@RequestBody BoardDto boardDto) {
        Board board = new Board(boardDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/boards/{id}") // 게시글 상세 화면
    public Long DetailBoard(@PathVariable Long id) {
        return id;
    }

}
