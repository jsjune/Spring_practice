package com.sparta.deliveryapp.dto;

import com.sparta.deliveryapp.model.Foods;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderResponseDto {
    private String restaurantName;
    private List<FoodResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;


    public OrderResponseDto(String restaurantName, List<FoodResponseDto> foodResponseDtos) {
        this.restaurantName=restaurantName;
        this.foods=foodResponseDtos;
    }

    public OrderResponseDto(String restaurantName, List<FoodResponseDto> foodResponseDtos, int deliveryFee, int totalPrice) {
        this.restaurantName=restaurantName;
        this.foods=foodResponseDtos;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}
