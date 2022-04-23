package com.sparta.deliveryapp.model;

import com.sparta.deliveryapp.dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

//    @Column(nullable = false)
//    private int paramX;
//
//    @Column(nullable = false)
//    private int paramY;

    public Restaurant(RestaurantDto restaurantDto) {
        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }
}
