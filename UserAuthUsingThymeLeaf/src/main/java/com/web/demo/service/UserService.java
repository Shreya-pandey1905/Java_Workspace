package com.web.demo.service;

import com.web.demo.entities.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService  {
    public Users registerUser(Users users);

    public Users checkUser(Users users);
}
