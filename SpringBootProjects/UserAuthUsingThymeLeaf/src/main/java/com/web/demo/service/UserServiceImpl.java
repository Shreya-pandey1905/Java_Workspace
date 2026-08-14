package com.web.demo.service;

import com.web.demo.Exceptions.EmployeeNotExistException;
import com.web.demo.entities.Users;
import com.web.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public Users registerUser(Users users) {
        return userRepo.save(users);
    }

    @Override
    public Users checkUser(Users users) {

        Users users1=userRepo.findByEmailAndPassword(users.getEmail(),users.getPassword());
        if (users1 !=null){
            return users1;
        }else {
            throw new EmployeeNotExistException("Employee dont exist");
        }
    }
}
