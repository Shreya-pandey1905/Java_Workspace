package org.Student;

import entities.Certificate;
import entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.IOException;

public class Insert {

    public static void main(String[] args) throws IOException {
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Certificate certificate = new Certificate();

        certificate.setCourseName("Java");
        certificate.setDuration("3 months");
        Student student = new Student();
        student.setName("Jake");
        student.setCertificate(certificate);




        session.persist(student);

        transaction.commit();

    }
}