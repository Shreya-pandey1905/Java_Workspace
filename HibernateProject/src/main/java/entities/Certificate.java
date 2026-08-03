package entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Certificate {
    @Override
    public String toString() {
        return "Certificate{" +
                "courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    private String courseName;
    private String duration;

    public Certificate(){

    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


}
