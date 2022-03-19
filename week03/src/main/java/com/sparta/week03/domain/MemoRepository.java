package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<com.sparta.week03.domain.Memo, Long> {
    List<com.sparta.week03.domain.Memo> findAllByOrderByModifiedAtDesc(); // findAll By Order By ModifiedAt Desc 다 찾아서 순서대로 정렬해라 수정된 날짜를 기준으로 내림차순(최신순)
}
