package com.userAuthentication.UserAuthentication.OAuthHandler;

import com.userAuthentication.UserAuthentication.customJwt.JwtService;
import com.userAuthentication.UserAuthentication.entity.UserAuthEntity;
import com.userAuthentication.UserAuthentication.repository.userAuthRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    private static final String PROVIDER="GITHUB";
    private final userAuthRepo userAuthRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    //Github returns something like this
//    {
//        "id":12345678
//            "login":"shreyapandey",--username
//            "email": "shreya@gmail.com",
//        "name": "Shreya Pandey""
//    }

    // once authentication is sompleted from github , onAuthentication success receieves authentication object
//
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User =(OAuth2User) authentication.getPrincipal(); //currently authenticated user.
        Object id= oAuth2User.getAttribute("id"); // Github+providerId uniquely identifies the github account..
        String providerId= String.valueOf(id);
        String login = oAuth2User.getAttribute("login"); // username
        String email = oAuth2User.getAttribute("email"); // email

        if (email==null){ // if user's public email is hidden/not public by provider
            email= providerId+"+"+login+"@users.noreply.github.com"; // to create  email-like identifier for our app

            UserAuthEntity appUser = findOrCreate(providerId,login, email);// if existing, return updated details/ for 1st time customer,create/register new info
            String token= jwtService.generateToken(appUser.getEmail(),appUser.getRole());
            response.getWriter().write(
                    """
                            {
                            "token":"%s",
                            "email":"%s"
                            }
                      """.formatted(token,appUser.getEmail())
            );
        }


        }
    private UserAuthEntity findOrCreate(String providerId, String login, String email){
        return userAuthRepo.findByProviderAndProviderId(PROVIDER,providerId) // 2nd visit via github
                .orElseGet(()->
                        userAuthRepo.findByEmail(email) // existing user coming via github
                                .map(existing->{
                            existing.setProviderId(providerId);
                            existing.setProvider(PROVIDER);
                            return userAuthRepo.save(existing);
                        })
                                .orElseGet(()->//1st time

                                        userAuthRepo.save(UserAuthEntity.builder()
                                                .username(login)
                                                .email(email)
                                                .role("USER")// default role for any user coming form 3rd party
                                                .password(passwordEncoder.encode(UUID.randomUUID().toString()
                                                )
                                        )
                                                .providerId(providerId)
                                                .provider(PROVIDER)
                                                .build()
                                        )
                                )


                );
    }
}
