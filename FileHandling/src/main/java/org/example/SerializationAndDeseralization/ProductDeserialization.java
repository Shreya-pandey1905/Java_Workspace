package org.example.SerializationAndDeseralization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ProductDeserialization {


    static void main() throws IOException, ClassNotFoundException {
        try( ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/pdt.ser")))
        {
            Product product =(Product) inputStream.readObject();
            System.out.println(product);
        }
    }

}
