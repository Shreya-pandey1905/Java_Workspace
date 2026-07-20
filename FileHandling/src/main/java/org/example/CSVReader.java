package org.example;

import org.example.SerializationAndDeseralization.Employee;

import java.io.*;

public class CSVReader {
    static void main() throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/empInfo.csv"))){
            int count=0;
            double avg_sal =0.0;

            String line;
            while ((line=bufferedReader.readLine())!=null){
                String []arr= line.split(",");

                double sal=Double.parseDouble(arr[2]);

                Employee2 employee = new Employee2(arr[0],Integer.parseInt(arr[1]),sal);

                System.out.println(employee);
                        count++;



            }
            System.out.println("No of employees: "+count);
            System.out.println(sal);
        }
    }
    }

