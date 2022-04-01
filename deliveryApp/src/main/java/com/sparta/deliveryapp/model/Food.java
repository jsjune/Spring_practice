package com.sparta.deliveryapp.model;

import javax.persistence.*;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Restaurant restaurant;

    @Column(nullable = false)
    private String foodName;

    @Column(nullable = false)
    private int foodPrice;
}
