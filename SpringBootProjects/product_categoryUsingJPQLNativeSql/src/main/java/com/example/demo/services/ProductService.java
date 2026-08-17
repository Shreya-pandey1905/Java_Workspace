package com.example.demo.services;

import com.example.demo.entities.Products;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Products> getAllProduct(){
        List<Products> products = productRepo.findAll();
        for(Products product : products){
            System.out.println(product.getCategory().getName());
        }
        return products;
    }


}