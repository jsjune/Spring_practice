package com.sparta.deliveryapp.controller;

import com.sparta.deliveryapp.dto.OrderDto;
import com.sparta.deliveryapp.dto.OrderRequestDto;
import com.sparta.deliveryapp.model.OrderList;
import com.sparta.deliveryapp.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 주문
    @PostMapping("/order/request")
    public OrderDto foodOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.setOrder(orderRequestDto);
    }

    // 주문 조회
    @GetMapping("/orders")
    public List<OrderList> showOrder() {
        return orderService.showOrder();
    }
}
