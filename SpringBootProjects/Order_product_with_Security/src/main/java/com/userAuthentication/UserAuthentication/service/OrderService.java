package com.userAuthentication.UserAuthentication.service;

import com.userAuthentication.UserAuthentication.dto.OrderRequest;
import com.userAuthentication.UserAuthentication.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(
    OrderRequest request, Long userId);

    OrderResponse getOrderById(Long id);

    List<OrderResponse> getAllOrders();

    List<OrderResponse> getOrdersByUser(Long userId);

    void cancelOrder(Long id);
}
