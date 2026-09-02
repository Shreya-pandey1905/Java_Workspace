package com.userAuthentication.UserAuthentication.service;

import com.userAuthentication.UserAuthentication.entity.UserEntity;
import com.userAuthentication.UserAuthentication.repository.userAuthRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserService implements UserDetailsService {

    private final userAuthRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userAuthEntity= userRepo.findByEmail(username).get();
        UserDetails userDetails= User
                .builder()
                .username(userAuthEntity.getEmail())
                .password(userAuthEntity.getPassword())
                .roles(userAuthEntity.getRole())
                .build();

        return userDetails;


    }
}
