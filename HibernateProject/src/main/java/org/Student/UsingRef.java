package org.Student;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class UsingRef {



    public static void main(String[] args) {
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student user = session.getReference(Student.class,1);
        transaction.commit();
        System.out.println(user);



    }
}


