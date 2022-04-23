package com.sparta.deliveryapp.model;

import com.sparta.deliveryapp.dto.FoodOrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int quantity;


    public FoodOrder(Food food, int quantity) {
        this.name = food.getName();
        this.quantity = quantity;
        this.price = food.getPrice()*quantity;
    }
}
