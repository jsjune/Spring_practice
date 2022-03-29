package com.sparta.board.controller;

import com.sparta.board.domain.Comment;
import com.sparta.board.dto.CommentRequestDto;
import com.sparta.board.repository.BoardRepository;
import com.sparta.board.repository.CommentRepository;
import com.sparta.board.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public CommentController(BoardRepository boardRepository, CommentRepository commentRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
    }

    @PostMapping("/api/details/{id}/comments")
    public Comment createComment(@PathVariable("id") Long boardId, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        boardRepository.findById(boardId).orElseThrow(
                ()->new NullPointerException("아이디X")
        );
        requestDto.setBoardId(boardId);
        requestDto.setWriter(userDetails.getUsername());
        Comment comment = new Comment(requestDto);
        commentRepository.save(comment);
        return comment;
    }
}
