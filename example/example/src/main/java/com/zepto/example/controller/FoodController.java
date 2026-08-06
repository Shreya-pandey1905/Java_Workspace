package com.zepto.example.controller;

import com.zepto.example.entities.Food;
import com.zepto.example.entities.Food;
import com.zepto.example.service.FoodService;
import com.zepto.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodController")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping("/addFood")
    public void addFood(@RequestBody Food food){
        foodService.add(food);
    }

    @PostMapping("/addAllFood")
    public void addAllFood (@RequestBody List<Food> food){
        foodService.addAll(food);
    }

    @GetMapping("/getById/{id}")
    public Food getFood(@PathVariable int id){
        return foodService.get(id);
    }

    @GetMapping("/getAll")
    public List<Food> getAllFood(){
        return foodService.getAll();
    }

    @GetMapping("/getByName/{name}")
    public Food getName(@PathVariable String name){
        return foodService.getName(name);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteFoodById(@PathVariable int id){
        foodService.deleteById(id);
    }

    @DeleteMapping("/deleteAllFood")
    public void deleteAllFood(){
        foodService.deleteAll();
    }

    @PatchMapping("updateFoodById/{id}")
    public void update(@PathVariable int id, @RequestBody Food clothing){
        foodService.update(id, clothing);

    }



}
