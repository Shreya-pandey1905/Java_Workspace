package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

 class EmployeeDetails {
    int id;
    String name;
    LocalDate doj;

    public EmployeeDetails(int id, String name, LocalDate doj) {
        this.id = id;
        this.name = name;
        this.doj = doj;
    }


    public void yearsOfExp(){
        LocalDate localDate = LocalDate.now();
        Period period = Period.between(doj,localDate);
        System.out.println("Years of exp: "+period.getYears());
    }


     @Override
     public String toString() {
         return "EmployeeDetails{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 ", doj=" + doj +
                 '}';
     }
 }

public class Employee {
    public static void main(String[] args){
        var emp = new EmployeeDetails(1,"JAKE",LocalDate.of(2023,01,01));

        System.out.println(emp);

       emp.yearsOfExp();
    }
}
