package com.sparta.deliveryapp.service;

import com.sparta.deliveryapp.dto.RestaurantDto;
//import com.sparta.deliveryapp.model.Food;
import com.sparta.deliveryapp.model.Restaurant;
//import com.sparta.deliveryapp.repository.FoodRepository;
import com.sparta.deliveryapp.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    private static final int MIN_ORDERPRICE = 1000; // 100원 단위로만 입력 가능
    private static final int MAX_ORDERPRICE = 100000;
    private static final int MIN_DELIVERYFEE = 0; // 500원 단위로만 입력 가능
    private static final int MAX_DELIVERYFEE = 10000;
    private static final int MIN_FOODPRICE = 100; // 100원 단위로만 입력 가능
    private static final int MAX_FOODPRICE = 1000000;
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 100;
    // "주문 음식 가격들의 총 합"이 주문 음식점의 "최소주문 가격"을 넘지 않을 시 에러 발생

    public static void restaurantExceptions(RestaurantDto restaurantDto) {
        if (restaurantDto.getMinOrderPrice() > MAX_ORDERPRICE || restaurantDto.getMinOrderPrice() < MIN_ORDERPRICE) {
            throw new IllegalArgumentException("최소주문 가격 허용값 예외");
        }
        if (restaurantDto.getMinOrderPrice() % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로만 입력가능");
        }
        if (restaurantDto.getDeliveryFee() > MAX_DELIVERYFEE || restaurantDto.getDeliveryFee() < MIN_DELIVERYFEE) {
            throw new IllegalArgumentException("배달비 허용값 예외");
        }
        if (restaurantDto.getDeliveryFee() % 500 != 0) {
            throw new IllegalArgumentException("500원 단위로만 입력가능");
        }
    }

    public Restaurant setRestaurant(RestaurantDto restaurantDto) {
        restaurantExceptions(restaurantDto);
        Restaurant restaurant = new Restaurant(restaurantDto);
        restaurantRepository.save(restaurant);
//        System.out.println(restaurant.getDeliveryFee());
        return restaurant;
    }

    public List<Restaurant> showFood() {
        return restaurantRepository.findAll();
    }
}

