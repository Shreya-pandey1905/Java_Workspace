package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String classCode =
                "public class Student {" +
                        "    public void display() {" +
                        "        System.out.println(\"Hello Student\");" +
                        "    }" +
                        "}";

        FileWriter writer = new FileWriter("Student.java");
        writer.write(classCode);
        writer.close();

        System.out.println("Student.java created");
    }
}