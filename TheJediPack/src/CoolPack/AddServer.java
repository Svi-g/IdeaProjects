package CoolPack;
//A Simple Client/Server Application Using RMI
// Main program

import java.rmi.*;
public class AddServer {
    public static void main(String... args) {
        try {
            AddServerImpl addServerImpl = new AddServerImpl();
            Naming.rebind("AddServer", addServerImpl);
        }
        catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}

