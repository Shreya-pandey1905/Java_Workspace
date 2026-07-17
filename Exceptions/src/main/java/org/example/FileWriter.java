package org.example;

import java.io.*;

public class FileWriter {
    static void main() throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new java.io.FileWriter("src/employe.txt",true))){
            String line;
          bw.write("hello");
          bw.newLine();
        }
    }
}
