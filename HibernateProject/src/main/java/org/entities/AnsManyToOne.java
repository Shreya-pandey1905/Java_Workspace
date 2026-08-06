package org.entities;

import jakarta.persistence.*;

@Entity
public class AnsManyToOne {
    public AnsManyToOne() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;


    @ManyToOne
    QnsOneToMany qnsOneToMany ;
    String answers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public QnsOneToMany getQnsOneToMany() {
        return qnsOneToMany;
    }

    public void setQnsOneToMany(QnsOneToMany qnsOneToMany) {
        this.qnsOneToMany = qnsOneToMany;
    }


}
