package com.sparta.board.controller;

import com.sparta.board.domain.Board;
import com.sparta.board.dto.BoardDto;
import com.sparta.board.repository.BoardRepository;
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

    @GetMapping("/api/details") // 상세 페이지 이동
    public String detailBoard() {
        return "/detail.html";
    }

    @ResponseBody
    @GetMapping("/api/details/{id}") // 게시글 상세 화면
    public Board detailBoard1(@PathVariable Long id) {
        Board board = boardRepository.findById(id).orElseThrow( // 필요한 정보를 찾는다
                () -> new IllegalArgumentException()
        );
        return board;
    }

//     게시글 수정
//    @ResponseBody
//    @PutMapping("/api/details/?id={id}")
//    public Long updateContents(@PathVariable Long id, @RequestBody BoardDto boardDto) {
//        boardService.update(id, boardDto);
//        return id;
//    }

    @ResponseBody
    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }
}
