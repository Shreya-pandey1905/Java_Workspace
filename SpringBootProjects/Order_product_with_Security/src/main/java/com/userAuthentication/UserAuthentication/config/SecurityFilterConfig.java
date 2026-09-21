package com.userAuthentication.UserAuthentication.config;


import com.userAuthentication.UserAuthentication.OAuthHandler.OAuth2LoginSuccessHandler;
import com.userAuthentication.UserAuthentication.customJwt.JwtService;
import com.userAuthentication.UserAuthentication.filter.JwtAuthFilter;
import com.userAuthentication.UserAuthentication.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityFilterConfig {

    @Bean
    public SecurityFilterChain getSecurity(HttpSecurity httpSecurity,
                                           JwtService jwtService,
                                           CustomUserService customUserService,
                                           AuthenticationEntryPoint authenticationEntryPoint,
                                            OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler){

        JwtAuthFilter jwtAuthFilter = new JwtAuthFilter(jwtService,customUserService);


        httpSecurity.csrf(csrf->csrf.disable());// cross site resource forgery

            httpSecurity.authorizeHttpRequests(request ->request
                    .requestMatchers("/users/registerUser","/users/loginUser"
                            ,"/oauth2/**" // mainly used to strt oauth authentication
                            ,"/login/**")// containns spring security oauth callback url
                    .permitAll()
                     .requestMatchers("/users/loginUser").permitAll()
                    .requestMatchers("/users/getAll").hasRole("ADMIN")
                     .requestMatchers("/users/profile").authenticated()

                   .requestMatchers("/users/update").authenticated()
                   .requestMatchers("/users/getById/{id}").hasRole("ADMIN")

                    .anyRequest()
                    .authenticated()//not only register user authenticate to all apis
            );
//        httpSecurity.formLogin(Customizer.withDefaults());  both are normal authentication methods
//        httpSecurity.httpBasic(Customizer.withDefaults());

        //making session stateless
        httpSecurity.sessionManagement(httpSecuritySessionManagementConfigurer ->
                httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //exception point for unauthenticated users
                .exceptionHandling(ex->ex.authenticationEntryPoint(authenticationEntryPoint))
                //adding our customized filter before UsernamePasswordAuthenticationFilter
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .oauth2Login(oauth2->oauth2.successHandler(oAuth2LoginSuccessHandler));

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncrypt(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(CustomUserService customUserService,PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider(customUserService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(daoAuthenticationProvider);

    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return (request, response, authException) -> {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write("{\"Status\":401,\"error\":Unauthorized\","
        +"\"message\":\"Missing or invalid bearer token\"}");
        };

    }
}
