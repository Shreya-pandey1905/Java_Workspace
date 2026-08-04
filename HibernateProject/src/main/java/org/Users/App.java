package org.Users;

import org.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        User user = new User("Jake","jake@gmail.com","123","Male","New York");
        User user2 = new User("Chris","chris@gmail.com","123","Male","New York");
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        session.persist(user2);
        transaction.commit();


    }
}
