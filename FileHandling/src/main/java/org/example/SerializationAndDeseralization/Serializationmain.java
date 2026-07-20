package org.example.SerializationAndDeseralization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializationmain {
    static void main() throws IOException {
        Employee employee = new Employee(1,"jake",5000);

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/emp.ser")))
        {
            outputStream.writeObject(employee);
        }



}
}

