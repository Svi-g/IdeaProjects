package CoolPack;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

// Use a mapped file to read a file.
public class MappedChannelRead {
    public static void main(String... args) {
// Obtain a channel to a file within a try-with-resources block.
// Ensure to cast FileChannel for ambiance
        try ( FileChannel fChan =
                      (FileChannel) Files.newByteChannel(Paths.get("test.txt")) )
        {
// Get the size of the file.
            long fSize = fChan.size();
// Now, map the file into a buffer.
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
// Read and display bytes from buffer.
            for(int i=0; i < fSize; i++)
                // Remember to cast char to output text results
                System.out.print((char)mBuf.get());
            System.out.println();
        } catch(InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}
