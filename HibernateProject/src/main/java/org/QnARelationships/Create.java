package org.QnARelationships;

import org.entities.AnsManyToOne;
import org.entities.QnsOneToMany;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Create {
    public static void main(String[] args) throws IOException {
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        QnsOneToMany q1 = new QnsOneToMany();
        AnsManyToOne a1 = new AnsManyToOne();
        AnsManyToOne a2 = new AnsManyToOne();
        AnsManyToOne a3 = new AnsManyToOne();


        q1.setQuestion("What is Characteristics of java?");
        a1.setAnswers("Secure");
        a2.setAnswers("Platform Independent");
        a3.setAnswers("Supports multiple frameworks");

        a1.setQnsOneToMany(q1);
        a2.setQnsOneToMany(q1);
        a3.setQnsOneToMany(q1);

        List<AnsManyToOne> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        q1.setAnswers(list);

        session.persist(q1);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);


        transaction.commit();

    }
}
