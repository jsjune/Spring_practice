package com.sparta.deliveryapp.controller;

import com.sparta.deliveryapp.dto.FoodDto;
import com.sparta.deliveryapp.dto.RestaurantDto;
import com.sparta.deliveryapp.model.Food;
import com.sparta.deliveryapp.model.Restaurant;
import com.sparta.deliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    // 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant restaurantRegister(@RequestBody RestaurantDto restaurantDto) {
        return;
    }

    // 음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> showRestaurant() {
        return;
    }

    // 음식 등록
    @PostMapping("/restaurant/{id}/food/register")
    public Food foodRegister(@RequestBody FoodDto foodDto) {
        return;
    }

    // 메뉴판 조회
    @GetMapping("/restaurant/{id}/foods")
    public Food showFood() {
        return;
    }
}
