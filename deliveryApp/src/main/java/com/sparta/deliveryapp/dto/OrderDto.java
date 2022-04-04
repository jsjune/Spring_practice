package com.sparta.deliveryapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderDto {
    private String restaurantName;
    private List<FoodOrderDto> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderDto(String restaurantName, int deliveryFee, int totalPrice, ArrayList<FoodOrderDto> foodOrderDto) {
        this.restaurantName = restaurantName;
        this.foods = foodOrderDto;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}
