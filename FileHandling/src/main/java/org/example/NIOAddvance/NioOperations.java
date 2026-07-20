package org.example.NIOAddvance;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class NioOperations {

    static void main() throws IOException {
//        Files.copy(Path.of("src/employee.txt"),Path.of("src/empbackup.txt"));

//        Files.copy(Path.of("src/employee.txt"),Path.of("src/empbackup.txt"), StandardCopyOption.REPLACE_EXISTING);

          Files.move(Path.of("src/abc.txt"),Path.of("src/texts/newText123.txt"));

    }
}
