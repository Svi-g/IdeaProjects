package CoolPack;
import java.net.*;
import java.io.*;

/*
THis program shows how you can use whois to
get a domain's details from the Internic
server.
 */
public class WhoisDemo {
    public static void main(String... args) throws Exception {
        int c;
// Create a socket connected to internic.net, port 43.
       try ( Socket s = new Socket("whois.internic.net", 43) ) {

// Obtain input and output streams.
           InputStream in = s.getInputStream();
           OutputStream out = s.getOutputStream();
// Construct a request string.
           String str = (args.length == 0 ? "bash.com" : args[0]) + "\n";
// Convert to bytes.
           byte[] buf = str.getBytes();
// Send request.
           out.write(buf);
// Read and display response.
           while ((c = in.read()) != -1) {
               System.out.print((char) c);
           }
       }
        //s.close();
    }

}
