package com.example.week03.controller;

import com.example.week03.domain.Memo;
import com.example.week03.domain.MemoRepository;
import com.example.week03.domain.MemoRequestDto;
import com.example.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> GetMomos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

//    @PutMapping("/api/memos/{i}")
//    public Memo

    @DeleteMapping("api/memos/{i}")
    public Long deleteMemo(@PathVariable Long id) { // 주소에 있는걸 변수로 받기 위해 {id}
        memoRepository.deleteById(id);
        return id;
    }
}
