package CoolPack;
import java.io.*;

/*
This program shows how to use a FileReader.
 */
public class FileReaderDemo {
    public static void main(String... args) {
        try ( FileReader fr = new FileReader("FileReaderDemo.java") )
        {
            int c;
// Read and display the file.
            while((c = fr.read()) != -1) System.out.print((char) c);
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
