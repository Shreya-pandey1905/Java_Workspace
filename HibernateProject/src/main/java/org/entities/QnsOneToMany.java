package org.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class QnsOneToMany {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String question;

    @OneToMany
    @JoinTable(name = "qna")
    List<AnsManyToOne> ansManyToOne;

    public QnsOneToMany() {
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AnsManyToOne>  getAnswers() {
        return ansManyToOne;
    }

    public void setAnswers(List<AnsManyToOne>  ansManyToOne) {
        this.ansManyToOne = ansManyToOne;
    }

}
