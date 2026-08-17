package com.example.demo.repository;

import com.example.demo.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products,Integer> {

    //product above the price
    @Query("select p from Products p where p.price > :price ")
    public List<Products> findAbovePrice(@Param("price")Double price);

    //getting product by using category name
    @Query("select P from Products p where p.category.name = :categoryname")
    public List<Products> getProductsbyCategory(@Param("categoryName")String categoryName);

    //getting list of product whose price is between the range and stock is availabel (greater than 0)
    @Query("select p from Products p where p.price between :min and :max and stoke > 0")
    public List<Products> getRangeStockProduct(@Param("min")Double min,@Param("max")Double max);

    //sort the product base on price
    @Query("select P from Products p order by p.price desc")
    public List<Products> getSortedProducts();

    //getting product and category details based on coming category
    @Query("select p from Products p join from category where p.category = :category")
    public List<Products> getalldetails(@Param("category")String category);

    //same  with native way instead of jpa
    @Query(value = "select p from Products p where p.price between :min and :max and stoke > 0",nativeQuery = true)
    public List<Products> getRangeStockProductBYNative(@Param("min")Double min,@Param("max")Double max);
}