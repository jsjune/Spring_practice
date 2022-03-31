package com.sparta.jpa.repository;

import com.sparta.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAllByFavoriteFoodContaining(String word);
}