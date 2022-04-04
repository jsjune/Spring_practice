package com.sparta.deliveryapp.model;

import com.sparta.deliveryapp.dto.FoodOrderDto;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String restaurantName;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private int deliveryFee;

    @OneToMany
    private List<FoodOrder> foodOrder;


    public OrderList(String restaurantName, int deliveryFee, int totalPrice, ArrayList<FoodOrder> foodOrder) {
        this.restaurantName=restaurantName;
        this.deliveryFee=deliveryFee;
        this.totalPrice=totalPrice;
        this.foodOrder=foodOrder;
    }
}
