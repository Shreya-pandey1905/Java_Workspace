package com.inventory.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Grocery {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int productsId;
    private String productName;
    private String category;
    private double price;
    private int quantity;
    private double discount;

}


//send redirect-->datatype
// getattribute , setattr--> Model