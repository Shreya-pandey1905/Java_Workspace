package com.example.productcatalog1throughVersion.service;

import com.example.productcatalog1throughVersion.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Page<Products> getAll(int page, int size);

    Page<Products> getProductInOrder(int page , int size, String sortBy, String direction);

    Page<Products> findByCategory(int page , int size,String sortBy, String direction);
}
