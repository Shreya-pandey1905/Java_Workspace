package com.zepto.example.repository;

import com.zepto.example.entities.Clothing;
import com.zepto.example.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRep extends JpaRepository<Food,Integer> {
    public Food findByItemName(String name);

}
