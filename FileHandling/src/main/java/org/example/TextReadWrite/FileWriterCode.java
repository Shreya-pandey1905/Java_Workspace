package org.example.TextReadWrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterCode {

    public static void main(String[] args) throws IOException {



        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("src/employee.txt", true))) {

            bw.write("hello");
            bw.newLine();
        }
    }
}