package com.sparta.week03_homework.controller;

import com.sparta.week03_homework.domain.Memo;
import com.sparta.week03_homework.domain.MemoRepository;
import com.sparta.week03_homework.domain.MemoRequestDto;
import com.sparta.week03_homework.service.MemoService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @GetMapping("/api/memos")
    public List<Memo> getMemo(){
        LocalDateTime start = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(0,0,0));
        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,59,59));
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start,end);
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}
