package org.entities;

import jakarta.persistence.*;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String question;

    @OneToOne
    @JoinColumn(name = "question_answer")
    Answers answers;

    public Questions() {
    }
    public void setQuestion(String question) {
        this.question = question;
    }

      public void setAnswers(Answers answers) {
        this.answers = answers;
    }


}
