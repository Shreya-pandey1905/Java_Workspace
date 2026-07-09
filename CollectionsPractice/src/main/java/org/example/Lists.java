package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lists {
  public static void main(String[] args){
//      List<Person> people = new ArrayList<Person>();
//      people.add(new Person("jake",1,45) );
//      people.add(new Person("shreya",3,45) );
//      people.add(new Person("chris",2,45) );

      List<Emp> emp =new ArrayList<Emp>();
      emp.add(new Emp(1,"jake",50));
      emp.add(new Emp(2,"shreya",56));
      emp.add(new Emp(1,"jake",50));

      System.out.println(emp);
      Collections.sort(emp, new SortByName());
      System.out.println(emp);

  }
}
