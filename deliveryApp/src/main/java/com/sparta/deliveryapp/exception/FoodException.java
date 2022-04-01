package com.sparta.deliveryapp.exception;

public class FoodException {
    private final int MIN_ORDERPRICE = 1000; // 100원 단위로만 입력 가능
    private final int MAX_ORDERPRICE = 100000;
    private final int MIN_DELIVERYFEE = 0; // 500원 단위로만 입력 가능
    private final int MAX_DELIVERYFEE = 10000;
    private final int MIN_FOODPRICE = 100; // 100원 단위로만 입력 가능
    private final int MAX_FOODPRICE = 1000000;
    private final int MIN_QUANTITY = 1;
    private final int MAX_QUANTITY = 100;
    // "주문 음식 가격들의 총 합"이 주문 음식점의 "최소주문 가격"을 넘지 않을 시 에러 발생
}
