package org.example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NIOWrite {
    static void main() throws IOException {
        Path path = Path.of("src/employee.txt");
        try(FileChannel channel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING)){
        String  msg= "Chris \n Evans";
            ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
            channel.write(byteBuffer);

        }
    }
}
