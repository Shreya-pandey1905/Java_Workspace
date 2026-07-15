package org.example;

import java.util.*;

public class DulicatesRemoval {
    public static  void main(String[] args){
        List<String> ll = Arrays.asList("A","B","C","A","B");
        LinkedHashSet <String> lh = new LinkedHashSet<>(ll);

        List<String> ll2=new ArrayList<>(new LinkedHashSet<>(ll));



        System.out.println(ll2);


    }
}
