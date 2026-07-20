package org.example.SerializationAndDeseralization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ProductSerialization {
    static void main() throws IOException {
        Product product = new Product(1,"chocolate",2,500,"123");

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/pdt.ser")))
        {
            outputStream.writeObject(product);
        }
    }
}
