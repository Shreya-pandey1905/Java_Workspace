package com.web.demo.controller;

import com.web.demo.entities.Users;
import com.web.demo.service.UserServiceImpl;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserAuthController {

        @Autowired
        UserServiceImpl userService;

    @GetMapping("/register")
    public String userRegister( Model model){
        model.addAttribute("users",new Users());
        return "registerUser";
    }

    @PostMapping("/addUser")
    public String adduser( @ModelAttribute Users users, Model model){
        Users users1= userService.registerUser(users);
        if (users1!=null){
            model.addAttribute("success","Registered Successfully");

        }else {
            model.addAttribute("error","Registration Failed");
        }
        return "registerUser";
    }

    @GetMapping("/loginUser")
    public String loginUser(Model model){
        model.addAttribute("loginUser",new Users());
        return "loginUser";
    }

    @PostMapping("/authorise")
    public String checkUser(@ModelAttribute Users loginUser, RedirectAttributes redirectAttributes){
        Users validUser= userService.checkUser(loginUser);
        if (validUser!=null){
            redirectAttributes.addFlashAttribute("name",validUser.getName());
            return "redirect:/profile";
        }else {
            redirectAttributes.addFlashAttribute("errorMsg","Login Successfully Failed!!");
            return "redirect:/loginUser";
        }
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session!=null){
            session.invalidate();
        }
        return "redirect:/loginUser";
    }



}
