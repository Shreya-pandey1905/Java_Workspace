package com.example.demo.controller;

import com.example.demo.entities.Orders;
import com.example.demo.service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    @Autowired
    OrderServices orderService   ;

    @GetMapping("/register")
    public String saveOrder(Model model) {

        model.addAttribute("order",new Orders());
        return "registerOrder";
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute Orders order, Model model){
        Orders order1= orderService.saveOrder(order);
        double totalAmount= order.getPrice()* order.getOrderQuantity();
        if (order1!=null && order1.getPaidOrNot().equalsIgnoreCase("yes")){

            model.addAttribute("paid","Total Amount paid: "+totalAmount);

        }else {
            model.addAttribute("notpaid","Amount to be  paid: "+totalAmount);
        }

        model.addAttribute("order", order);
        return "profile";
    }



}