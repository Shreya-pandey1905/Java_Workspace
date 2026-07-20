package org.example.SerializationAndDeseralization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DEserialization {


    static void main() throws IOException, ClassNotFoundException {
        try( ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/emp.ser")))
        {
            Employee e2 =(Employee) inputStream.readObject();
            System.out.println(e2);
        }
    }





}
