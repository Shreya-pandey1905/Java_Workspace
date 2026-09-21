package com.userAuthentication.UserAuthentication.repository;


import com.userAuthentication.UserAuthentication.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products ,Long> {
}