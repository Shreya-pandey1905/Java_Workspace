package org.Users;


import org.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchUsers {
    public static void main(String[] args) {
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

//        Query query = session.createQuery("from User");

//        Query query = session.createQuery("from User where city='Mumbai'");

//        Query query = session.createQuery("from User where city=:n");
//        query.setParameter("n","Mumbai");

//        Query query = session.createQuery("delete from User where city=:n");
//        query.setParameter("n","Mumbai");
//       int rows= query.executeUpdate();
//        System.out.println(rows);

//          Query query = session.createQuery("update User set city=:c where name=:n");
//          query.setParameter("c","Delhi");
//          query.setParameter("n","Sneha Patil");
//          int rows= query.executeUpdate();
//          System.out.println(rows);

//        Query query = session.createQuery("select q.question, q.id, a.id from Questions as q inner join q.answers as a");
//        List <Object[]> list = query.getResultList();
//        for (Object[] object: list){
//            System.out.println(Arrays.toString(object));
//        }

        Query query = session.createQuery("from User");
        query.setFirstResult(3);
        query.setMaxResults(5);

        List<User> list= query.list();
        System.out.println(list);




//       List<User> list= query.list();
//        System.out.println(list);
        transaction.commit();

    }
}

