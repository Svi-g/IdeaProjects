package CoolPack;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

/*
This program maps and then writes
to file through a channel without
using write() method.
 */
public class MappedChannelWrite {
    public static void main(String... args) {
// Obtain a channel to a file within a try-with-resources block.
        try ( FileChannel fChan = (FileChannel)
                Files.newByteChannel(Paths.get("Demo.rft"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.READ,
                        StandardOpenOption.CREATE) )
        {
// Then, map the file into a buffer.
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
// Write some bytes to the buffer.
            for(int i=0; i<26; i++)
                mBuf.put((byte)('A' + i));
        } catch(InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}
