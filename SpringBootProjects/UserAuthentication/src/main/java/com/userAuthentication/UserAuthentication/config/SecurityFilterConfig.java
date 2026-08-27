package com.userAuthentication.UserAuthentication.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterConfig {

    @Bean
    public SecurityFilterChain getSecurity(HttpSecurity httpSecurity){
        httpSecurity.csrf(csrf->csrf.disable());// cross site resource forgery

            httpSecurity.authorizeHttpRequests(request ->request
                    .requestMatchers("/users/registerUser")
                    .permitAll()
                     .requestMatchers("/users/loginUser").permitAll()
                    .requestMatchers("/users/profile").authenticated()
                   .requestMatchers("/users/update").authenticated()
                    .requestMatchers("/users/getAll").hasRole("ADMIN")
                    .requestMatchers("/users/getById/{id}").hasRole("ADMIN")

                    .anyRequest()
                    .authenticated()//not only register user authenticate to all apis
            );
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncrypt(){
        return new BCryptPasswordEncoder();
    }
}
