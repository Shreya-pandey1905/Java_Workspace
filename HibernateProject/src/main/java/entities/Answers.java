package entities;

import jakarta.persistence.*;

@Entity
public class Answers {
    public Answers() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    @OneToOne(mappedBy = "answer")
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



}
