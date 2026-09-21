package com.userAuthentication.UserAuthentication.serviceImpl;

import com.userAuthentication.UserAuthentication.dto.UserRequest;
import com.userAuthentication.UserAuthentication.dto.UserResponse;
import com.userAuthentication.UserAuthentication.entity.Role;
import com.userAuthentication.UserAuthentication.entity.User;
import com.userAuthentication.UserAuthentication.repository.UserRepository;
import com.userAuthentication.UserAuthentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createCustomer(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.CUSTOMER);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }

    @Override
    public UserResponse getCustomerById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (user.getRole() != Role.CUSTOMER) {
            throw new RuntimeException("Customer not found");
       }
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public List<UserResponse> getAllCustomers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> customers = new ArrayList<>();
        for (User user : users) {
            if (user.getRole() == Role.CUSTOMER) {
                customers.add(modelMapper.map(user, UserResponse.class));
            }
        }
        return customers;
    }
    @Override
    public UserResponse updateCustomer(Long id, UserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (user.getRole() != Role.CUSTOMER) {
            throw new RuntimeException("Customer not found");
        }
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUpdatedAt(LocalDateTime.now());
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserResponse.class);
    }

    @Override
    public void deleteCustomer(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (user.getRole() != Role.CUSTOMER) {
            throw new RuntimeException("Customer not found");
        }
        userRepository.delete(user);
    }
}