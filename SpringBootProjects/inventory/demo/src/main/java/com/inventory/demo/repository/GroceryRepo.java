package com.inventory.demo.repository;

import com.inventory.demo.entities.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryRepo extends JpaRepository<Grocery,Integer>
{
    public Grocery findByProductName(String name);

    public List<Grocery> findByCategory(String category);
}
