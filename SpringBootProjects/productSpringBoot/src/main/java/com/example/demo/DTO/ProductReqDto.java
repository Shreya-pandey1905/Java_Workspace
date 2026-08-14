package com.example.demo.DTO;

import lombok.Data;

@Data
public class ProductReqDto {

    private String name;
    private String description;
    private Double price;
    private Integer quantity;

}
