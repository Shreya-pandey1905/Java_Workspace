package org.entities;

import jakarta.persistence.*;

@Entity
public class Answers {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    @OneToOne
    Answers answers;
    public Answers() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }



}
