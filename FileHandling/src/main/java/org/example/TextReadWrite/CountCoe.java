package org.example.TextReadWrite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class CountCoe {

    static void main() throws IOException {
        int infoCount=0;
        int error=0;
        int warn=0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/loggerr.txt"))){
            String line;


            while ((line=bufferedReader.readLine())!=null){

                if (line.startsWith("INFO")){
                    infoCount++;
                }else if (line.startsWith("ERROR")){
                    error++;
                }else if (line.startsWith("WARN")){
                    warn++;
                }
//                System.out.println(line);

            }
            System.out.println("Warn count"+warn);

            System.out.println("Info count"+infoCount);
            System.out.println("Error Count"+error);


        }
    }
}
