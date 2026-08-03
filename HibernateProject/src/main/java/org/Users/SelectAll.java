package org.Users;

import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class SelectAll {



    public static void main(String[] args) {
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<User> userDetail =session.createQuery("from User",User.class).list();
        System.out.println(userDetail);
            transaction.commit();



    }
}


