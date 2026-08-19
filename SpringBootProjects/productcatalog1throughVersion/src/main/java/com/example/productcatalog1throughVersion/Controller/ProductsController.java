package com.example.productcatalog1throughVersion.Controller;

import com.example.productcatalog1throughVersion.entity.Products;
import com.example.productcatalog1throughVersion.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")

public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public Page<Products> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        return productService.getAll(page,size);
    }

    @GetMapping("/getAllBySort")
    public  Page<Products> getBySort(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size,
                                     @RequestParam(defaultValue = "id" ) String sortBy,
                                     @RequestParam(defaultValue = "ascending") String direction ){
        return productService.getProductInOrder(page,size,sortBy,direction);
    }
}
