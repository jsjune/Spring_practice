package com.sparta.deliveryapp.dto;

import com.sparta.deliveryapp.model.Food;
import com.sparta.deliveryapp.model.FoodOrder;
import lombok.Getter;

@Getter
public class FoodOrderDto {
    String name;
    int quantity;
    int price;

    public FoodOrderDto(FoodOrder foodOrder, int quantity) {
        this.name = foodOrder.getName();
        this.price = foodOrder.getPrice();
        this.quantity = quantity;
    }
}
