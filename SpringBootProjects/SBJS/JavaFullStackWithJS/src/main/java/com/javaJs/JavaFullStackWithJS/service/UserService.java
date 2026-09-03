package com.javaJs.JavaFullStackWithJS.service;

import com.javaJs.JavaFullStackWithJS.entity.Users;
import com.javaJs.JavaFullStackWithJS.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepo userRepo;

    public Users addUser(Users users){
    Users users1= userRepo.save(users);
    return users1;
    }

    public List<Users> findAll(){
      return userRepo.findAll();
    }
}
