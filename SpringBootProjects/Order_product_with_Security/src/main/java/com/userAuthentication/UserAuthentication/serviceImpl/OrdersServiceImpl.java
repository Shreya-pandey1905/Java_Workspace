package com.userAuthentication.UserAuthentication.serviceImpl;

import com.userAuthentication.UserAuthentication.dto.OrderRequest;
import com.userAuthentication.UserAuthentication.dto.OrderResponse;
import com.userAuthentication.UserAuthentication.entity.OrderStatus;
import com.userAuthentication.UserAuthentication.entity.Orders;
import com.userAuthentication.UserAuthentication.entity.Products;
import com.userAuthentication.UserAuthentication.entity.User;
import com.userAuthentication.UserAuthentication.repository.OrdersRepository;
import com.userAuthentication.UserAuthentication.repository.ProductRepository;
import com.userAuthentication.UserAuthentication.repository.UserRepository;
import com.userAuthentication.UserAuthentication.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrderService {

    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    @Override
    public OrderResponse createOrder(OrderRequest request, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Products product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStock() <= 0) {
            throw new RuntimeException("Product is out of stock");
        }

        Orders order = new Orders();
        order.setUser(user);
        order.setProduct(product);
        order.setTotalAmount(product.getPrice() - product.getDiscount());
        order.setStatus(OrderStatus.PLACED);
        order.setOrderDate(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        product.setStock(product.getStock() - 1);
        productRepository.save(product);
        Orders savedOrder = ordersRepository.save(order);
        return modelMapper.map(savedOrder, OrderResponse.class);
    }

    @Override
    public OrderResponse getOrderById(Long id) {

        Orders order = ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return modelMapper.map(order, OrderResponse.class);
    }

    @Override
    public List<OrderResponse> getAllOrders() {

        List<Orders> orders = ordersRepository.findAll();
        List<OrderResponse> orderList = new ArrayList<>();
        for (Orders order : orders) {
            orderList.add(modelMapper.map(order, OrderResponse.class));
        }
        return orderList;
    }

    @Override
    public List<OrderResponse> getOrdersByUser(Long userId) {

        List<Orders> orders = ordersRepository.findByUserId(userId);
        List<OrderResponse> orderList = new ArrayList<>();
        for (Orders order : orders) {
            orderList.add(modelMapper.map(order, OrderResponse.class));
        }
        return orderList;
    }

    @Override
    public void cancelOrder(Long id) {
        Orders order = ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(OrderStatus.CANCELLED);
        order.setUpdatedAt(LocalDateTime.now());
          ordersRepository.save(order);
    }
}