package com.example.demo.repository;

import com.example.demo.DTO.ProductReqDto;
import com.example.demo.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Integer> {
}
