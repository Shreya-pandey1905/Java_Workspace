package org.example;

import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter maximum number of students");
        int maxStudent = sc.nextInt();

        Services s = new Services(maxStudent);

        int userInput;

        do {

            System.out.println("Student App");
            System.out.println("Press 1 for adding a styudent");
            System.out.println("Press 2 for View Details ");
            System.out.println("Press 3 for searching student ");
            System.out.println("Press 4 for exit ");

            userInput = sc.nextInt();

            switch (userInput) {

                case 1:
                    s.add();
                    break;

                case 2:
                    s.showReport();
                    break;

                case 3:
                    s.search();
                    break;

                case 4:
                    System.out.println("Thank you for using our application");
                    break;

                default:
                    System.out.println("Invalid input ");
            }

        } while (userInput != 4);

    }
}