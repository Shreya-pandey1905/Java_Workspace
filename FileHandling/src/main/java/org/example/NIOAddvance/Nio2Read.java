package org.example.NIOAddvance;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Nio2Read {
    String content ;
    static void main() throws IOException {
     String content=Files.readString(Path.of("src/employee.txt"));
        System.out.println(content);
    }

}
