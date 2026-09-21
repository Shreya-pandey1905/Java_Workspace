package com.userAuthentication.UserAuthentication.dto;

import com.userAuthentication.UserAuthentication.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponse {

    private Long id;
    private Double totalAmount;
    private OrderStatus status;
    private Long userId;
    private Long productId;
    private LocalDateTime orderDate;
    private LocalDateTime updatedAt;
}