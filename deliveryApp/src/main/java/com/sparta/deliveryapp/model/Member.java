package com.sparta.deliveryapp.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity // Many쪽이 주인 // 값 수정, 삭제가능 // 연관관계의 주인은 외래 키의 위치를 기준으로 정해야함
public class Member {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
