package com.sparta.deliveryapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FoodDto {
    private Long id;
    private String name;
    private int price;
}
