package com.userAuthentication.UserAuthentication.controller;

import com.userAuthentication.UserAuthentication.dto.OrderRequest;
import com.userAuthentication.UserAuthentication.dto.OrderResponse;
import com.userAuthentication.UserAuthentication.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrderService ordersService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @Valid @RequestBody OrderRequest request,
            @RequestParam Long userId) {
        return ResponseEntity.ok(ordersService.createOrder(request, userId)
        );
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(ordersService.getOrderById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(ordersService.getAllOrders());
    }

    @GetMapping("/getByUser/{userId}")
    public ResponseEntity<List<OrderResponse>> getOrdersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(ordersService.getOrdersByUser(userId));
    }

    @PutMapping("/{id}/cancel")
   public ResponseEntity<String> cancelOrder(@PathVariable Long id) {
        ordersService.cancelOrder(id);
        return ResponseEntity.ok("Order has been cancelled");
    }
}