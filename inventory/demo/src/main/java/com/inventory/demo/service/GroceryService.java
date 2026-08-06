package com.inventory.demo.service;

import com.inventory.demo.entities.Grocery;
import com.inventory.demo.repository.GroceryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GroceryService{

@Autowired
    private GroceryRepo groceryRepo;

public void addProduct(Grocery grocery){
        groceryRepo.save(grocery);
}

public List<Grocery> addAllProducts(List<Grocery> grocery){
return  groceryRepo.saveAll(grocery);
}

public Grocery getById(int id){
    return groceryRepo.findById(id).get();
}

public List<Grocery> getAllProducts(){
    return groceryRepo.findAll();
}

public Grocery getName(String name){
    return groceryRepo.findByProductName(name);
}

    public List<Grocery> getByCategory(String category) {
        return groceryRepo.findByCategory(category);
    }

    public void update(int id, Grocery grocery){
        Grocery  grocery1= groceryRepo.findById(id).get();
        grocery1.setProductName(grocery.getProductName());
        grocery1.setPrice(grocery.getPrice());
        grocery1.setDiscount(grocery.getDiscount());
        grocery1.setCategory(grocery.getCategory());
        grocery1.setQuality(grocery.getQuality());
        groceryRepo.save(grocery1);
    }

    public void deleteById(int id){
        groceryRepo.deleteById(id);
    }

    public void deleteAll(){
        groceryRepo.deleteAll();
    }







}
