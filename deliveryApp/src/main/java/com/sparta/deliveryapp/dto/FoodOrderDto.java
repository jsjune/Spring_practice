package com.sparta.deliveryapp.dto;

import com.sparta.deliveryapp.model.Foods;
import lombok.Getter;

@Getter
public class FoodOrderDto {
    String name;
    int quantity;
    int price;

    public FoodOrderDto(Foods foods, int quantity) {
        this.name = foods.getName();
        this.price = foods.getPrice();
        this.quantity = quantity;
    }

    public FoodOrderDto(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
