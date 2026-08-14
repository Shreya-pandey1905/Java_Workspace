package com.example.demo.service;

import com.example.demo.DTO.ProductReqDto;
import com.example.demo.DTO.ProductResDto;
import com.example.demo.entities.Products;
import com.example.demo.repository.ProductsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductsService {

    @Autowired
    ProductsRepo productsRepo;

    @Autowired
    ModelMapper modelMapper;

    public void saveProduct(ProductReqDto reqDto){
//        Products products=new Products();
//       products.setName (reqDto.getName());

        Products products= modelMapper.map(reqDto,Products.class);
        productsRepo.save(products);
    }

    public  void saveAllProducts(List<ProductReqDto> reqDto){
        List<Products> productsList = new ArrayList<>();
        for (ProductReqDto prd: reqDto){
            Products products= modelMapper.map(prd,Products.class);
            Collections.addAll(productsList,products);
        }
                productsRepo.saveAll(productsList);

    }

    public List<ProductResDto> getAllProducts() {
        List<Products> productsList = productsRepo.findAll();
        List<ProductResDto> dtoList = new ArrayList<>();

        for (Products product : productsList) {
            ProductResDto dto = new ProductResDto();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setDescription(product.getDescription());
            dto.setPrice(product.getPrice());
            dto.setQuantity(product.getQuantity());
            dtoList.add(dto);
        }

        return dtoList;
    }

    public ProductResDto get(int id){

       Products products1= productsRepo.findById(id).get();

//
//        ProductResDto productResDto = new ProductResDto();
//       productResDto.setId(products1.getId());
//       productResDto.setName(products1.getName());
//        productResDto.setDescription(products1.getDescription());
//        productResDto.setPrice(products1.getPrice());
//        productResDto.setQuantity(products1.getQuantity());

        //using DTO
        ProductResDto productResDto =modelMapper.map(products1,ProductResDto.class);
      return productResDto;
    }



}
