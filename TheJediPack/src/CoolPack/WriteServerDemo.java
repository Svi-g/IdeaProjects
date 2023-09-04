package CoolPack;
import java.net.*;

/*
This program demonstrates a simple network
communication between a client and a server,
 */
public class WriteServerDemo {
    public static final int SERVER_PORT = 998;
    public static final int CLIENT_PORT = 999;
    public static final int BUFFER_SIZE = 1024;
    public static DatagramSocket ds;
    public static byte[] buffer = new byte[BUFFER_SIZE];

    public static void TheServer() {
        try {
            int pos = 0;
            while (true) {
                int c = System.in.read();
                switch (c) {
                    case -1:
                        System.out.println("Server Quits.");
                        ds.close();
                        return;
                    case '\r':
                        break;
                    case '\n':
                        ds.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), CLIENT_PORT));
                        pos = 0;
                        break;
                    default:
                        buffer[pos++] = (byte) c;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void TheClient() {
        try {
            while (true) {
                DatagramPacket p = new DatagramPacket(buffer, buffer.length);
                ds.receive(p);
                System.out.println(new String(p.getData(), 0, p.getLength()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        try {
            if (args.length == 1) {
                ds = new DatagramSocket(SERVER_PORT);
                TheServer();
            } else {
                ds = new DatagramSocket(CLIENT_PORT);
                TheClient();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
