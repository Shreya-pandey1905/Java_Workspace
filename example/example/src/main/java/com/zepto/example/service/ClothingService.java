package com.zepto.example.service;
import com.zepto.example.entities.Clothing;
import com.zepto.example.entities.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zepto.example.repository.ClothingRep;

import java.util.List;

@Service

public class ClothingService {


    @Autowired
    private ClothingRep clothingRep;

    public void add(Clothing clothing){
        clothingRep.save(clothing);
    }

    public List<Clothing> addAll(List<Clothing> clothing){
        return clothingRep.saveAll(clothing);
    }

    public Clothing get(int id){
       return clothingRep.findById(id).get();
    }

    public  List<Clothing> getAll(){
        return clothingRep.findAll();
    }

    public void deleteById(int id){
        clothingRep.deleteById(id);
    }

    public void deleteAll(){
        clothingRep.deleteAll();
    }

    public void update(int id, Clothing clothing){
      Clothing  clothing1= clothingRep.findById(id).get();
        clothing1.setItemName(clothing.getItemName());
        clothing1.setDiscount(clothing.getDiscount());
        clothing1.setPrice(clothing.getPrice());
        clothingRep.save(clothing1);
    }

    public Clothing getName(String name){
        return clothingRep.findByItemName(name);
    }
}

