package org.Users;

import org.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update {
    public static void main(String[] args) {
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.find(User.class,4);
        user.setName("Megan");
        session.persist(user);
        System.out.println(user);
        transaction.commit();


    }
}
