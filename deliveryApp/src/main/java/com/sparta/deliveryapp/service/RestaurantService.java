package com.sparta.deliveryapp.service;

import com.sparta.deliveryapp.dto.FoodDto;
import com.sparta.deliveryapp.dto.RestaurantDto;
import com.sparta.deliveryapp.model.Food;
import com.sparta.deliveryapp.model.Restaurant;
import com.sparta.deliveryapp.repository.FoodRepository;
import com.sparta.deliveryapp.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, FoodRepository foodRepository) {
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
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

    private static void restaurantExceptions(RestaurantDto restaurantDto) {
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

    // 음식점 등록
    public Restaurant setRestaurant(RestaurantDto restaurantDto) {
        restaurantExceptions(restaurantDto);
        Restaurant restaurant = new Restaurant(restaurantDto);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    // 음식점 조회
    public List<Restaurant> showFood() {
        return restaurantRepository.findAll();
    }

    // 음식 예외
    private static void foodExceptions(Food food) {
        if (food.getFoodPrice() < MIN_FOODPRICE || food.getFoodPrice() > MAX_FOODPRICE) {
            throw new IllegalArgumentException("음식 가격 예외");
        }
        if (food.getFoodPrice() % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로만 입력가능");
        }
    }

    // 음식 등록
    @Transactional
    public void setFood(Long restaurantId,List<FoodDto> foodDto){
//        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
//                ()->new IllegalArgumentException("아이디X")
//        );
//        HashSet<String> foodset = new HashSet<>();
//        for (FoodDto newfood : foodDto) {
//            foodset.add(newfood.getName());
//        }
//        if (foodset.size() != foodDto.size()) {
//            throw new IllegalArgumentException("입력된 음식명에 중복 에러");
//        }
        for (FoodDto newfood : foodDto) {
            List<Food> result = foodRepository.findByRestaurantIdAndFoodName(restaurantId, newfood.getName()) ;
            if (result.size()>0) {
                throw new IllegalArgumentException("음식 중복 에러");
            }
            Food food = new Food(newfood,restaurantId);
            System.out.println(newfood.toString());
            foodExceptions(food);
            foodRepository.save(food);
        }
    }

    // 메뉴판 조회
    public List<Food> show(Long restaurantId){
        return foodRepository.findAllByRestaurantId(restaurantId);
    }

}

