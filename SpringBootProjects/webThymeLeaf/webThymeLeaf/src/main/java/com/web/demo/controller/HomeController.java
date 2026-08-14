package com.web.demo.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

//    @GetMapping("/openProfile")
//    public String openProfile(){
//return "profile";
//    }
        @GetMapping("/openProfile")
    public String openProfile(Model model){
            String name="Jake";
            model.addAttribute("name_key",name);
        return "profile";
    }

    @GetMapping("/compare")
    public String compareNumber(Model model){
            model.addAttribute("num1",60);
            model.addAttribute("num2",50);
            return "numberCompare";
    }

    @GetMapping("/looping")
    public String looping(Model model){
        List<Integer> list=List.of(11,27,33,44);
        model.addAttribute("List",list);
        return "loop";
    }



}
