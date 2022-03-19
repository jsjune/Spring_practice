package com.example.week03.service;

import com.example.week03.domain.Memo;
import com.example.week03.domain.MemoRepository;
import com.example.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, MemoRequestDto requestDto) { // 변경시킬때 필요한 정보를 물고 다니는 녀석을 Dto
        Memo memo = memoRepository.findById(id).orElseThrow( // 필요한 정보를 찾는다
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto); // 업데이트
        return memo.getId();
    }
}
