package com.sparta.deliveryapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String restaurantName;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private int deliveryFee;

    @OneToMany
    private List<Foods> foods;

    public OrderList(String restaurantName, int deliveryFee, int totalPrice, ArrayList<Foods> foods) {
        this.restaurantName=restaurantName;
        this.deliveryFee=deliveryFee;
        this.totalPrice=totalPrice;
        this.foods = foods;
    }
}
