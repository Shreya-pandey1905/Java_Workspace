package util;

import dao.StudentDao;
import model.Students;

import java.util.Scanner;

import static dao.StudentDao.view;

public class StartUputil {

    public static void input() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the student");
        int id = sc.nextInt();
        System.out.println("Enter the name pf the student");
        String name = sc.next();
        System.out.println("Enter the course name");
        String course = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter student marks ");
        int marks = sc.nextInt();

        Students students = new Students(id,name,course,marks);
        StudentDao.add(students);

    }

    public static void delete() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id ");

        int studID = sc.nextInt();
        StudentDao.delete(studID);
    }


    public static void update() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id");
        int sid = sc.nextInt();
        System.out.println("Enter student marks ");
        int marks2 = sc.nextInt();
        StudentDao.update(sid,marks2);
    }

    public static void print() throws Exception {


            int userInput;


            do{
                Scanner sc = new Scanner(System.in);
                System.out.println("Student Application");
                System.out.println("Press 1 for adding student");
                System.out.println("Press 2 for viewing student details ");
                System.out.println("Press 3 for delete student by id");
                System.out.println("Press 4 for update student by id");
                System.out.println("Press 5 for exiting the application");

                 userInput = sc.nextInt();

                switch (userInput){
                    case 1:
                        input();
                        break;
                    case 2:
                        view();
                        break;
                    case 3:
                      delete();
                        break;
                    case 4:
                        update();
                        break;
                    case 5:
                        System.out.println("Thank you for using application");
                        break;
                }
            }while (userInput!=5);


        }
}
