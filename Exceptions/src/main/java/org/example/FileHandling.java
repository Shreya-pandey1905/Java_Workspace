package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling {
    static void main() throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/employe.txt"))){
            String line;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }
    }
}
