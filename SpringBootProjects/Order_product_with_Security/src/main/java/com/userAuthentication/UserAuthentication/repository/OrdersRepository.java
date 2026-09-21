package com.userAuthentication.UserAuthentication.repository;


import com.userAuthentication.UserAuthentication.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByUserId(Long userId);
}