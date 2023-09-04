package CoolPack;
import java.io.*;
import java.util.*;
// Demonstrate sequenced input.
// This program uses the traditional approach to closing a file.

class InputStreamEnumerator implements Enumeration<FileInputStream>, AutoCloseable {
    private final Enumeration<String> files;

    public InputStreamEnumerator(Vector<String> files) {
        this.files = files.elements();
    }

    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement());
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void close() throws IOException {
        // Close any resources here if needed
    }
}

public class SequenceInputStreamDemo {
    public static void main(String... args) {
        int c;
        Vector<String> files = new Vector<>();
        files.addElement("file1.txt");
        files.addElement("file2.txt");
        files.addElement("file3.txt");

        try (InputStreamEnumerator ise = new InputStreamEnumerator(files)) {
            try (InputStream input = new SequenceInputStream(ise)) {
                while ((c = input.read()) != -1)
                    System.out.print((char) c);
            } catch (IOException e) {
                System.out.println("I/O Error: " + e);
            }
        } catch (NullPointerException e) {
            System.out.println("Error Opening File.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}