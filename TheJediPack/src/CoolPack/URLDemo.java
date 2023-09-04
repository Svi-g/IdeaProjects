package CoolPack;
import java.net.*;

/*
This program shows how to examine a
URL and its properties.
 */
public class URLDemo {
    public static void main(String... args) throws MalformedURLException {
        URL hp = new URL("https://www.bash.com/WhatsNew");
        System.out.println("Protocol: " + hp.getProtocol());
        System.out.println("Port: " + hp.getPort());
        System.out.println("Host: " + hp.getHost());
        System.out.println("File: " + hp.getFile());
        System.out.println("Ext: " + hp.toExternalForm());
    }
}
