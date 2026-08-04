package org.Student;


import org.entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Find {



    public static void main(String[] args) {
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student user = session.find(Student.class,1);
       // System.out.println(user);
        transaction.commit();
      //  System.out.println(user);



    }
}


