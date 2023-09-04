package CoolPack;
import java.net.*;

/*
This demo shows a local host address,
ne address yezinye iiwebsite.
 */
public class InetAddressDemo {
    public static void main(String... args) throws UnknownHostException {
        InetAddress Address = InetAddress.getLocalHost();
        System.out.println(Address);
        Address = InetAddress.getByName("www.takealot.com");
        System.out.println(Address);
        InetAddress[] SW = InetAddress.getAllByName("www.sars.gov.za");
        for (InetAddress inetAddress : SW) System.out.println(inetAddress);
    }
}
