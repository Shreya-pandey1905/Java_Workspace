package org.QnA;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.IOException;


public class Create {

    public static void main(String[] args) throws IOException {
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

//        Questions questions= new Questions();
//        Answers answers= new Answers();
//
//        answers.setAnswers("HCL is the formula");
//        questions.setQuestion("What is the formula for Hydrocholoric acid");
//        questions.setAnswers(answers);
//
//
//        session.persist(answers);
//
//        session.persist(questions);
//
//
//        transaction.commit();

    }
}