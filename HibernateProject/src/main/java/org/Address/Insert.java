package org.Address;

import entities.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

public class Insert {

    public static void main(String[] args) throws IOException {
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        FileInputStream fileInputStream = new FileInputStream("src/images/img.jpg");
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);


        Address address1 = new Address();
        address1.setCity("Varanasi");
        address1.setStreet("Benaras");
        address1.setOpen(true);
        address1.setDate(LocalDate.of(2026, 1, 1));
        address1.setImage(data);
        address1.setX(10.5);



        session.persist(address1);

        transaction.commit();

    }
}