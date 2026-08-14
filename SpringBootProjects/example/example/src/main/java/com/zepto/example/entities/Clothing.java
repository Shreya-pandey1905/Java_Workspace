package com.zepto.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Clothing {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private double price;
    private double discount;

}
