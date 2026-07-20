package org.example.TextReadWrite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
    static void main() throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/employee.txt"))){
            String line;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }
    }
}
