package com.example.demo.service;

import com.example.demo.entities.Orders;
import com.example.demo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    public Orders saveOrder(Orders order) {
        return orderRepo.save(order);
    }
}
