package com.sparta.deliveryapp.repository;

import com.sparta.deliveryapp.model.Foods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<Foods, Long> {
}
