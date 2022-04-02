package com.sparta.deliveryapp.controller;

import com.sparta.deliveryapp.dto.FoodDto;
import com.sparta.deliveryapp.dto.RestaurantDto;
import com.sparta.deliveryapp.model.Food;
import com.sparta.deliveryapp.model.Restaurant;
import com.sparta.deliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    // 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant restaurantRegister(@RequestBody RestaurantDto restaurantDto) {
        return restaurantService.setRestaurant(restaurantDto);
    }

    // 음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> showRestaurant() {
        return restaurantService.showFood();
    }

    // 음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register") // 식당id
    public void foodRegister(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDto) {
        restaurantService.setFood(restaurantId,foodDto);
    }

    // 메뉴판 조회
    @GetMapping("/restaurant/{restaurantId}/foods") // 식당id
    public List<Food> showFood(@PathVariable Long restaurantId) {
        return restaurantService.show(restaurantId);
    }
}
