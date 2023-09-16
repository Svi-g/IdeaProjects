package CoolPack;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

/*
This program shows how to copy()
a file using NIO.
 */
public class NIOCopyDemo {
    public static void main(String... args) {
        if(args.length != 2) {
            System.out.println("Usage: Copy from to");
            return;
        }
        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);
// Copy the file.
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch(InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }

}
