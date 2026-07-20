package org.example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NIOMain {
    static void main() throws IOException {
        Path path = Path.of("src/employee.txt");

        try(FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)){ //TODO:open will opens the file for reading operation.
            ByteBuffer buffer= ByteBuffer.allocate(1024); // TODO: CREATES MEMORY TO LOAD DATA
            while (channel.read(buffer)>0); //TODO: COPIES DATA FROM FILE INTO BUFFER
            buffer.flip(); //TODO: WHILE WRITING FROM THE FILE INTO BUFFER ITS POSITION MOVES THE END OF THE BUFFER,
            //todo: SO BEFORE READING WE MUST CALL flip() TO BRING THE CURSOR TO THE BEGINNING OF BUFFER.
            // WITHOUT buffere,flip() there will be no data BECAUSE THE POSITION WIILL BE AT THE END .
            while (buffer.hasRemaining()){ // todo: reads the byte from buffer one by one
                System.out.println((char)buffer.get());
            }
          buffer.clear(); // todo: clears the buffer so that it can be filled.
        }
    }
}
