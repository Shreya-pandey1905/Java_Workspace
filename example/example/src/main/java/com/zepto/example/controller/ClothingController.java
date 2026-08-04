package com.zepto.example.controller;

import com.zepto.example.entities.Clothing;
import com.zepto.example.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothingController")
public class ClothingController {

    @Autowired
    private ClothingService clothingService;

    @PostMapping("/addClothing")
    public void addClothing(@RequestBody Clothing clothing){
        clothingService.add(clothing);
    }

    @PostMapping("/addAllClothing")
    public void addAllClothing (@RequestBody List<Clothing> clothing){
        clothingService.addAll(clothing);
    }

    @GetMapping("/getById/{id}")
    public void getClothing(@PathVariable int id){
        clothingService.get(id);
    }

   @GetMapping("/getAll")
   public List<Clothing> getAllClothing(){
        return clothingService.getAll();
    }

    @DeleteMapping("/deleteById/{id}")
       public void deleteClothingById(@PathVariable int id){
        clothingService.deleteById(id);
    }

    @DeleteMapping("/deleteAllClothing")
        public void deleteAllClothing(){
        clothingService.deleteAll();
    }

    @PutMapping("updateClothingById/{id}")
        public void update(@PathVariable int id, @RequestBody Clothing clothing){
            clothingService.update(id, clothing);

        }
}
