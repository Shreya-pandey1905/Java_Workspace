package org.example;

import java.util.ArrayList;

public class Emp {



    static void main(String[] args) {
        var name="Jake";
        var dept="IT";

        var salary=100000.99;

        var cities = new ArrayList<>();
        cities.add("Mumbai");
        cities.add("Pune");
        cities.add("Pali");


        for (var i: cities){
            System.out.println(i);
        }

        System.out.println(name);
        System.out.println(dept);
//        System.out.println(cities);
        System.out.println(salary);


    }
}
