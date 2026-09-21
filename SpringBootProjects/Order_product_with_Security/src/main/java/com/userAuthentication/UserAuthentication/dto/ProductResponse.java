package com.userAuthentication.UserAuthentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {

    private Long id;
    private String itemName;
    private String productDetails;
    private Double price;
    private Integer stock;
    private Double discount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}