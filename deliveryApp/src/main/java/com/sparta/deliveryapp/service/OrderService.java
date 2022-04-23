package com.sparta.deliveryapp.service;

import com.sparta.deliveryapp.dto.*;
import com.sparta.deliveryapp.model.Food;
import com.sparta.deliveryapp.model.Foods;
import com.sparta.deliveryapp.model.OrderList;
import com.sparta.deliveryapp.model.Restaurant;
import com.sparta.deliveryapp.repository.FoodOrderRepository;
import com.sparta.deliveryapp.repository.FoodRepository;
import com.sparta.deliveryapp.repository.OrderRepository;
import com.sparta.deliveryapp.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final OrderRepository orderRepository;
    private final FoodOrderRepository foodOrderRepository;

    public OrderService(RestaurantRepository restaurantRepository, FoodRepository foodRepository, OrderRepository orderRepository, FoodOrderRepository foodOrderRepository) {
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
        this.orderRepository = orderRepository;
        this.foodOrderRepository = foodOrderRepository;
    }

    // 수량 예외처리
    private static void orderException(OrderRequestDto orderRequestDto) {
        for (int i = 0; i < orderRequestDto.getFoods().size(); i++) {
            if(orderRequestDto.getFoods().get(i).getQuantity()<1||orderRequestDto.getFoods().get(i).getQuantity()>100)
                throw new IllegalArgumentException("허용값 예외");
        }
    }

    // 최종 금액 예외처리
    private static void orderPriceException(int totalPrice,int deliveryFee,int minOrderPrice) {
        if (totalPrice - deliveryFee < minOrderPrice) {
            throw new IllegalArgumentException("최종 결제 금액 예외");
        }
    }

    // 주문
    @Transactional
    public OrderDto setOrder(OrderRequestDto orderRequestDto) {
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException("아이디X")
        );
        String restaurantName =  restaurant.getName();
        int deliveryFee = restaurant.getDeliveryFee();
        int totalPrice = deliveryFee;

        ArrayList<FoodOrderDto> foodOrderDto = new ArrayList<>();
        ArrayList<Foods> foods = new ArrayList<>();

        orderException(orderRequestDto);

        for (FoodOrderRequestDto foodOrderRequestDto : orderRequestDto.getFoods()) {
            Food food = foodRepository.findById(foodOrderRequestDto.getId()).orElseThrow(
                    ()->new IllegalArgumentException("아이디X")
            );
            int quantity = foodOrderRequestDto.getQuantity();
            Foods order = new Foods(food,quantity);

            FoodOrderDto foodOrderDto1 = new FoodOrderDto(order,quantity);
            foodOrderDto.add(foodOrderDto1);

            foods.add(order);
            foodOrderRepository.save(order);

            totalPrice+=order.getPrice();
        }

        orderPriceException(totalPrice,deliveryFee,restaurant.getMinOrderPrice());

        OrderDto orderDto = new OrderDto(restaurantName,deliveryFee,totalPrice,foodOrderDto);
        OrderList oderList = new OrderList(restaurantName,deliveryFee,totalPrice, foods);
//        System.out.println(orderDto.getFoods().size());
        orderRepository.save(oderList);
        System.out.println(orderDto.getRestaurantName());
        return orderDto;
    }

    // 주문 조회
//    public List<OrderList> showOrder(){
//        return orderRepository.findAll();
//    }
    public List<OrderResponseDto> showOrder(){
        List<OrderList> orderLists = orderRepository.findAll();
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        List<FoodResponseDto> foodResponseDtos = new ArrayList<>();

        String restaurantName = orderLists.get(0).getRestaurantName();
        int deliveryFee = orderLists.get(0).getDeliveryFee();
        int totalPrice = orderLists.get(0).getTotalPrice();

        for (int i = 0; i < orderLists.get(0).getFoods().size(); i++) {
            String name = orderLists.get(0).getFoods().get(i).getName();
            int price = orderLists.get(0).getFoods().get(i).getPrice();
            int quantity = orderLists.get(0).getFoods().get(i).getQuantity();

            FoodResponseDto foodResponseDto = new FoodResponseDto(name,price,quantity);
            foodResponseDtos.add(foodResponseDto);

        }
        OrderResponseDto orderResponseDto = new OrderResponseDto(restaurantName,foodResponseDtos,deliveryFee,totalPrice);
        orderResponseDtos.add(orderResponseDto);
        return orderResponseDtos;
    }
}
