package com.example.productcatalog1throughVersion.service;

import com.example.productcatalog1throughVersion.DTO.ReqDto;
import com.example.productcatalog1throughVersion.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Page<Products> getAll(int page, int size);

    Page<Products> getProductInOrder(int page , int size, String sortBy, String direction);

    List<Products> findByCategory(String category);

    Products findById(Long id);

   void deleteById(Long id);

   Products createAllProducts( ReqDto products);



}
