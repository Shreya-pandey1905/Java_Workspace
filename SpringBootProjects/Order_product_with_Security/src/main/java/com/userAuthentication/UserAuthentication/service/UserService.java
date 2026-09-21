package com.userAuthentication.UserAuthentication.service;

import com.userAuthentication.UserAuthentication.dto.UserRequest;
import com.userAuthentication.UserAuthentication.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createCustomer(UserRequest request);

    UserResponse getCustomerById(Long id);

    List<UserResponse> getAllCustomers();

    UserResponse updateCustomer(Long id, UserRequest request);

    void deleteCustomer(Long id);
}
