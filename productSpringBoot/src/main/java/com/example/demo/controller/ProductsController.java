package com.example.demo.controller;

import com.example.demo.DTO.ProductReqDto;
import com.example.demo.DTO.ProductResDto;
import com.example.demo.entities.Products;
import com.example.demo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productsController")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @PostMapping("/saveAllProducts")
    public void saveAllProducts(@RequestBody List<ProductReqDto> products){
            productsService.saveAllProducts(products);
    }

    @PostMapping("/saveProduct")
    public void saveAllProducts(@RequestBody ProductReqDto products){
        productsService.saveProduct(products);
    }

    @GetMapping("/getAllProducts")
    public List<ProductResDto> getAllProducts(){
        return productsService.getAllProducts();
    }

    @GetMapping("/getById/{id}")
    public ProductResDto getProducts(@PathVariable int id){
        return productsService.get(id);
    }
}
