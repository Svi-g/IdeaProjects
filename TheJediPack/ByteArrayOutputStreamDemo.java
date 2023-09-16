package CoolPack;
import java.io.*;
/*
This program demonstrates how to use a
byte array as a destination.
 */
public class ByteArrayOutputStreamDemo {
    public static void main(String... args) {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "This should end up in the array";
        byte[] buf = s.getBytes();
        try {
            f.write(buf);
        } catch(IOException e) {
            System.out.println("Error Writing to Buffer");
            return;
        }
        System.out.println("Buffer as a string");
        System.out.println(f);
        System.out.println("Into array");
        byte[] b = f.toByteArray();
        for (byte value : b) System.out.print((char) value);
        System.out.println("\nTo an OutputStream()");
// Use try-with-resources to manage the file stream.
        try ( FileOutputStream f2 = new FileOutputStream("test.txt") )
        {
            f.writeTo(f2);
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
            return;
        }
        System.out.println("Doing a reset");
        f.reset();
        for (int i=0; i<3; i++) f.write('X');
        System.out.println(f);
    }
}
