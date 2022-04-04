package com.sparta.deliveryapp.service;

import com.sparta.deliveryapp.dto.FoodOrderDto;
import com.sparta.deliveryapp.dto.FoodOrderRequestDto;
import com.sparta.deliveryapp.dto.OrderDto;
import com.sparta.deliveryapp.dto.OrderRequestDto;
import com.sparta.deliveryapp.model.Food;
import com.sparta.deliveryapp.model.FoodOrder;
import com.sparta.deliveryapp.model.OrderList;
import com.sparta.deliveryapp.model.Restaurant;
import com.sparta.deliveryapp.repository.FoodOrderRepository;
import com.sparta.deliveryapp.repository.FoodRepository;
import com.sparta.deliveryapp.repository.OrderRepository;
import com.sparta.deliveryapp.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
//    @Transactional
    public OrderDto setOrder(OrderRequestDto orderRequestDto) {
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException("아이디X")
        );
        String restaurantName =  restaurant.getName();
        int deliveryFee = restaurant.getDeliveryFee();
        int totalPrice = deliveryFee;

        ArrayList<FoodOrderDto> foodOrderDto = new ArrayList<>();
        ArrayList<FoodOrder> foodOrder = new ArrayList<>();

        orderException(orderRequestDto);

        for (FoodOrderRequestDto foodOrderRequestDto : orderRequestDto.getFoods()) {
            Food food = foodRepository.findById(foodOrderRequestDto.getId()).orElseThrow(
                    ()->new IllegalArgumentException("아이디X")
            );
            int quantity = foodOrderRequestDto.getQuantity();
            FoodOrder order = new FoodOrder(food,quantity);

            FoodOrderDto foodOrderDto1 = new FoodOrderDto(order,quantity);
            foodOrderDto.add(foodOrderDto1);

            foodOrder.add(order);
            foodOrderRepository.save(order);

            totalPrice+=order.getPrice();
        }

        orderPriceException(totalPrice,deliveryFee,restaurant.getMinOrderPrice());

        OrderDto orderDto = new OrderDto(restaurantName,deliveryFee,totalPrice,foodOrderDto);
        OrderList oderList = new OrderList(restaurantName,deliveryFee,totalPrice,foodOrder);
//        System.out.println(orderDto.getFoods().size());
        orderRepository.save(oderList);
        return orderDto;
    }

    // 주문 조회
    public List<OrderList> showOrder() {
        return orderRepository.findAll();
    }
}
