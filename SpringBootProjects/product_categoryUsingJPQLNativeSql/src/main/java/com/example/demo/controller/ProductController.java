package com.example.demo.controller;

import com.example.demo.entities.Products;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//json--->c
//c---->json
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getAllProduct")
    public List<Products> getAllProduct(){
        return productService.getAllProduct();
    }

}