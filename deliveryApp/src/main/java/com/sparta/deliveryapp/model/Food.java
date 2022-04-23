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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id" ) // 단방향
    private Restaurant restaurant;

//    @ManyToOne
//    @JoinColumn(name = "restaurant_name")
    @Column(nullable = false)
    private String restaurantName;

//    @Column(nullable = false)
//    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    public Food(FoodDto foodDto, Restaurant restaurant) {
        this.name=foodDto.getName();
        this.price=foodDto.getPrice();
        this.restaurant=restaurant;
        this.restaurantName=restaurant.getName();
    }



//    public Food(FoodDto foodDto, Long restaurantId) {
//        this.name=foodDto.getName();
//        this.price=foodDto.getPrice();
//        this.restaurantId=restaurantId;
//    }
}
