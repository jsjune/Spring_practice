package com.sparta.deliveryapp.dto;

import lombok.Getter;

@Getter
public class FoodResponseDto {
    private String name;
    private int price;
    private int quantity;

    public FoodResponseDto(String name, int price, int quantity) {
        this.name=name;
        this.price = price;
        this.quantity = quantity;
    }
}
