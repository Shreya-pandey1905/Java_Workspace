package com.example.productcatalog1throughVersion.repository;

import com.example.productcatalog1throughVersion.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Long> {

    List<Products> findByCategory(String category);


}
