package org.entities;

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

       public void setDuration(String duration) {
        this.duration = duration;
    }

     public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


}
