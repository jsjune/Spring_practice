package com.sparta.deliveryapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Foods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int quantity;


    public Foods(Food food, int quantity) {
        this.name = food.getName();
        this.quantity = quantity;
        this.price = food.getPrice()*quantity;
    }
}
