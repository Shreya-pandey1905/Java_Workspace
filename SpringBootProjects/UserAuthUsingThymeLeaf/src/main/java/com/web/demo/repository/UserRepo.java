package com.web.demo.repository;

import com.web.demo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    public Users findByEmailAndPassword(String email, String password);
}
