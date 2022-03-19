package com.sparta.week03_homework.service;

import com.sparta.week03_homework.domain.Memo;
import com.sparta.week03_homework.domain.MemoRepository;
import com.sparta.week03_homework.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(memoRequestDto);
        return memo.getId();
    }
}
