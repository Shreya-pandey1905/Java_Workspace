package com.example.demo.DTO;

import lombok.Data;

@Data
public class ProductResDto {

    private int id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;

}
