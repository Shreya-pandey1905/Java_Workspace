package org.Users;

import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FindData {



        public static void main(String[] args) {
           Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            User user = session.find(User.class,3);
            transaction.commit();
            System.out.println("id:"+ " "+user.getId()+"name:"+" "+user.getName()+"email:"+" "+ user.getEmail());



        }
    }


