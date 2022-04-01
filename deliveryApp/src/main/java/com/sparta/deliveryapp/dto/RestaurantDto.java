package com.sparta.deliveryapp.dto;

import lombok.Getter;

@Getter
public class RestaurantDto {
//    private Long id;
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
