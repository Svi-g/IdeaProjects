package CoolPack;
import java.io.*;
import java.nio.file.*;

/*
This program uses NIO to open a file
and obtain a stream.
 */
public class NIOShowFileDemo {
    public static void main(String... args)
    {
        int i;
// First, confirm that a filename has been specified.
        if(args.length != 1) {
            System.out.println("Usage: ShowFile filename");
            return;
        }
// Open the file and obtain a stream linked to it.
        try ( InputStream fin = Files.newInputStream(Paths.get("Demo.txt")))
        {
            do {
                i = fin.read();
                if(i != -1) System.out.print((char) i);
            } while(i != -1);
        } catch(InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch(IOException e) {
            System.out.println("I/O Error " + e);
        }
    }

}
