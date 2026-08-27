package com.userAuthentication.UserAuthentication.service;

import com.userAuthentication.UserAuthentication.config.ModelMapperConfig;
import com.userAuthentication.UserAuthentication.config.SecurityFilterConfig;
import com.userAuthentication.UserAuthentication.customJwt.JwtService;
import com.userAuthentication.UserAuthentication.dto.*;
import com.userAuthentication.UserAuthentication.entity.UserAuthEntity;
import com.userAuthentication.UserAuthentication.repository.userAuthRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    userAuthRepo userAuthRepo;

    @Autowired
    ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;





    @Override
    public UserAuthResponseDto registerUser(UserAuthRequestDto requestDto) {

        UserAuthEntity user= modelMapper.map(requestDto,UserAuthEntity.class);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));

        UserAuthEntity userAuthEntity= userAuthRepo.save(user);
         return modelMapper.map(userAuthEntity,UserAuthResponseDto.class);
    }

    @Override
    public List<UserAuthResponseDto> findAll() {

        List<UserAuthEntity> users =  userAuthRepo.findByRole("USER");

        List<UserAuthResponseDto> dtoList = new ArrayList<>();

             for (UserAuthEntity user : users) {
            UserAuthResponseDto resDto = modelMapper.map(user,UserAuthResponseDto.class);
            dtoList.add(resDto);
        }
        return dtoList;
    }

    @Override
    public UserAuthResponseDto getById(Long id) {
        UserAuthEntity user = userAuthRepo.findById(id).get();
        UserAuthResponseDto response =modelMapper.map(user, UserAuthResponseDto.class);
        return response;
    }

    @Override
    public LoginResponseDto loginUser(LoginReqDTO reqDTO) {
//        UserAuthEntity user= userAuthRepo.findByEmail(reqDTO.getEmail())
//                .orElseThrow(()->new UsernameNotFoundException("User not available"));
//
//        String password =user.getPassword();
//        if (passwordEncoder.matches(reqDTO.getPassword(),password)){
//            UserAuthResponseDto response =modelMapper.map(user, UserAuthResponseDto.class);
//            return response;
//        }
//         throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid Credentials");

        try {
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken
                    .unauthenticated(reqDTO.getEmail(),reqDTO.getPassword()));

        }catch (AuthenticationException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid Credentials");
        }
        UserAuthEntity user = userAuthRepo.findByEmail(reqDTO.getEmail())
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
        LoginResponseDto responseDto= modelMapper.map(user,LoginResponseDto.class);
        responseDto.setToken(jwtService.generateToken(user.getEmail(),user.getRole()));
        return responseDto;
    }

    @Override
    public UserAuthResponseDto updateUser(ProfileUpdateDto request,UserDetails userDetails) {
        UserAuthEntity user = userAuthRepo.findByEmail(userDetails.getUsername())
                .orElseThrow(()-> new UsernameNotFoundException("User not available"));

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        UserAuthEntity userAuthEntity= userAuthRepo.save(user);
        return modelMapper.map(userAuthEntity,UserAuthResponseDto.class);
    }

    @Override
    public UserAuthResponseDto getUserProfile(String username) {
       UserAuthEntity user=userAuthRepo.findByEmail(username)
               .orElseThrow(()->new UsernameNotFoundException("User not available"));
        UserAuthResponseDto response =modelMapper.map(user, UserAuthResponseDto.class);
        return response;

    }


}
