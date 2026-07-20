package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageWrite {

    static void main() throws IOException {
        try(FileInputStream inputStream = new FileInputStream("src/kitty.jpg");
            FileOutputStream outputStream = new FileOutputStream("src/newFile.jpg"))

        {
            int data;
            while ((data=inputStream.read())!= -1){
                outputStream.write(data);
            }
        }

    }
}
