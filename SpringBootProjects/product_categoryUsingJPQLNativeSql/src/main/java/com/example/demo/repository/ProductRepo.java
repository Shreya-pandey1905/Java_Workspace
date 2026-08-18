package com.example.demo.repository;

import com.example.demo.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Products,Integer>{


    //product above the price
    @Query("select p from Products p where p.price>:price")
    List<Products> findAbovePrice(@Param("price") Double price);

    //getting product by using category name
    @Query("select p from Products p where p.category.name=:categoryName")
    List<Products> getProductsByCategory(@Param("categoryName") String categoryName);

    //getting list of product whose price is between the range and stock is available (greater than 0)
    @Query("select p from Products p where p.price between :min and :max and p.stock='Available'")
    List<Products> getRangeStockProduct(@Param("min") Double min,@Param("max") Double max);

    //sort the product base on price
    @Query("select p from Products p order by p.price desc")
    List<Products> getSortedProducts();

    //getting product and category details based on coming category
    @Query("select p from Products p join p.category c where c.name=:categoryName")
    List<Products> getAllDetails(@Param("categoryName") String categoryName);

    //same  with native way instead of jpa
    @Query(value="select * from products where price between :min and :max and stock='Available'",nativeQuery=true)
    List<Products> getRangeStockProductByNative(@Param("min") Double min,@Param("max") Double max);
}