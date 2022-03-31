package com.sparta.board.service;

import com.sparta.board.domain.Board;
import com.sparta.board.dto.BoardDto;
import com.sparta.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


//@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, BoardDto requestDto) { // 변경시킬때 필요한 정보를 물고 다니는 녀석을 Dto
        Board board = boardRepository.findById(id).orElseThrow( // 필요한 정보를 찾는다
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDto); // 업데이트
        return board.getId();

    }
}
