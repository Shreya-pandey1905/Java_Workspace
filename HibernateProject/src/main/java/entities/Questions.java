package entities;

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

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }


}
