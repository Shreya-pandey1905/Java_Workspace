package org.com.masstechBuisnessSolutions;

import java.util.Scanner;

public class EmpBonusCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee's name");
        String emp_name = sc.nextLine();
        System.out.println("Enter salary");
        double salary = sc.nextDouble();
        System.out.println("Enter performance rating");
        String performanceRating = sc.next();

        switch (performanceRating) {
            case "A":
                double bonusAmount= 0.2*salary;
                System.out.println("Employee name is: " + emp_name);
                System.out.println("Employee salary is: "+ salary);
                System.out.println("Rating is : "+ performanceRating);
                System.out.println("Bonus Amount: "+ bonusAmount);
                System.out.println("Final salary: "+ bonusAmount + salary);
            case "B":
                double bonusAmountOfB= 0.15 * salary;
                System.out.println("Employee name is: " + emp_name);
                System.out.println("Employee salary is: "+ salary);
                System.out.println("Rating is : "+ performanceRating);
                System.out.println("Bonus Amount: "+ bonusAmountOfB);
                System.out.println("Final salary: "+ bonusAmountOfB + salary);
            case "C":
                double bonusAmountOfC= 0.1*salary;
                System.out.println("Employee name is: " + emp_name);
                System.out.println("Employee salary is: "+ salary);
                System.out.println("Rating is : "+ performanceRating);
                System.out.println("Bonus Amount: "+ bonusAmountOfC);
                System.out.println("Final salary: "+ bonusAmountOfC + salary);
            case "D":
                double bonusAmountOfD= 0.05 *salary;
                System.out.println("Employee name is: " + emp_name);
                System.out.println("Employee salary is: "+ salary);
                System.out.println("Rating is : "+ performanceRating);
                System.out.println("Bonus Amount: "+ bonusAmountOfD);
                System.out.println("Final salary: "+ bonusAmountOfD + salary);


        }


    }
}
