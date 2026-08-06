package com.inventory.demo.controller;

import com.inventory.demo.entities.Grocery;
import com.inventory.demo.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groceryController")
public class GroceryController {

    @Autowired
   private GroceryService groceryService;

    @PostMapping("/addGrocery")
    public void addProduct(@RequestBody Grocery grocery){
        groceryService.addProduct(grocery);
    }

    @PostMapping("/addAllProducts")
    public void addAllClothing (@RequestBody List<Grocery> grocery){
        groceryService.addAllProducts(grocery);
    }

    @GetMapping("/getProductById/{id}")
    public void getById(int id){
        groceryService.getById(id);
    }

    @GetMapping("/getAllProducts")
    public List<Grocery> getAllClothing(){
        return groceryService.getAllProducts();
    }

    @GetMapping("/getByName")
    public Grocery getNameByRp(@RequestParam String name){
        return groceryService.getName(name);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteClothingById(@PathVariable int id){
        groceryService.deleteById(id);
    }

    @PatchMapping("updateById/{id}")
    public void update(@PathVariable int id, @RequestBody Grocery grocery){
        groceryService.update(id, grocery);
    }


    @GetMapping("/getByCategory/{category}")

    public List<Grocery> findByCategory(@PathVariable String category){
        return groceryService.getByCategory(category);
    }



}
