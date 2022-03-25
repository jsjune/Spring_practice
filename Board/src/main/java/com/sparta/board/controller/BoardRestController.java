package com.sparta.board.controller;

import com.sparta.board.domain.Board;
import com.sparta.board.domain.BoardDto;
import com.sparta.board.domain.BoardRepository;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardRestController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/api/boards") // 전체 게시글 목록으로 보여주기
    @ResponseBody
    public List<Board> MainBoard() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @ResponseBody
    @PostMapping("/api/boards") // 게시글 작성
    public Board createBoard(@RequestBody BoardDto boardDto) {
        Board board = new Board(boardDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/boards/detail")
    public String detailBoard(@RequestParam("id") String id) { // RequestParam은 /detail?id=${id}에서 id의 값을 의미한다
        return "/detail.html";
    }

    @ResponseBody
    @GetMapping("/api/detail/{id}") // 게시글 상세 화면
    public Board detailBoard1(@PathVariable Long id) {
        Board board = boardRepository.findById(id).orElseThrow( // 필요한 정보를 찾는다
                () -> new IllegalArgumentException()
        );
        return board;
    }

    @DeleteMapping("/api/detail/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }
}
