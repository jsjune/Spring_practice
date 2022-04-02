package com.sparta.deliveryapp.model;

import com.sparta.deliveryapp.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "restaurant_id") // 단방향
//    private Restaurant restaurant;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String foodName;

    @Column(nullable = false)
    private int foodPrice;

//    public Food(FoodDto foodDto, Restaurant restaurant) {
//        this.foodName=foodDto.getName();
//        this.foodPrice=foodDto.getPrice();
//        this.restaurant=restaurant;
//    }

    public Food(FoodDto foodDto, Long restaurantId) {
        this.foodName=foodDto.getName();
        this.foodPrice=foodDto.getPrice();
        this.restaurantId=restaurantId;
    }
}
