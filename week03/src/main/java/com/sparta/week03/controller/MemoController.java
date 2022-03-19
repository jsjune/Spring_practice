package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
//import com.sparta.week03.domain.Memo;
//import com.sparta.week03.domain.MemoRepository;
//import com.sparta.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) { // 클라이언트가 데이터를 보내면 요청이 날아올때 body라는 녀석을 여기에 넣어줘
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> GetMomos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }


    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto) {
        memoService.update(id,requestDto);
        return id;
    }

    @DeleteMapping("api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) { // 주소에 있는걸 변수로 받기 위해 {id}
        memoRepository.deleteById(id);
        return id;
    }
}
