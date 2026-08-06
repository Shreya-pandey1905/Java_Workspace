package com.zepto.example.service;

import com.zepto.example.entities.Food;
import com.zepto.example.repository.FoodRep;
import com.zepto.example.repository.FoodRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
   @Autowired
   private FoodRep foodRep;

    public void add(Food food){
        foodRep.save(food);
       }

    public List<Food> addAll(List<Food> foods){
        return foodRep.saveAll(foods);
    }

    public Food get(int id){
        return foodRep.findById(id).get();
    }

    public  List<Food> getAll(){
        return foodRep.findAll();
    }

    public void deleteById(int id){
        foodRep.deleteById(id);
    }

    public void deleteAll(){
        foodRep.deleteAll();
    }

    public void update(int id, Food food){
        Food  food1= foodRep.findById(id).get();
        food1.setItemName(food.getItemName());
        food1.setDiscount(food.getDiscount());
        food1.setPrice(food.getPrice());
        foodRep.save(food1);
    }

    public Food getName(String name){
        return foodRep.findByItemName(name);
    }

}
