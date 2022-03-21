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

    @ResponseBody
    @GetMapping("/api/boards") // 전체 게시글 목록으로 보여주기
    public List<Board> MainBoard(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @ResponseBody
    @PostMapping("/api/boards") // 게시글 작성
    public Board createBoard(@RequestBody BoardDto boardDto) {
        Board board = new Board(boardDto);
        return boardRepository.save(board);
    }

//    @RequestMapping(value="/api/boards/{id}",method=RequestMethod.GET)
//    public void detalBoard(Board ) {
//
//    }

    @GetMapping("/api/boards/{id}") // 게시글 상세 화면
    public Board DetailBoard(@PathVariable Long id) {
        return boardRepository.findById(id).get();
    }

//    @GetMapping("/api/boards/{id}") // 게시글 상세 화면
//    public Board DetailBoard(Board board) {
//        return board;
//    }
//    @GetMapping("/api/boards/{id}") // 게시글 상세 화면
//    public Long DetailBoard() {
//        return "detail";
//    }

}
