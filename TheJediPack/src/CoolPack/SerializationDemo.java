package CoolPack;
import java.io.*;
/*
The program shows to use object Serialisation
and Deserialization. We will use FileOutputStream
and FileInputStream.
 */

class Siyaserialisa {
    public static void main(String... args) {
// Object serialization
        try ( ObjectOutputStream objOStrm =
                      new ObjectOutputStream(new FileOutputStream("serial")) )
        {
            SerializationDemo object1 = new SerializationDemo("Hello", -7, 2.7e10);
            System.out.println("object1: " + object1);
            objOStrm.writeObject(object1);
        }
        catch(IOException e) {
            System.out.println("Exception during serialization: " + e);
        }
// Object deserialization
        try ( ObjectInputStream objIStrm =
                      new ObjectInputStream(new FileInputStream("serial")) )
        {
            SerializationDemo object2 = (SerializationDemo)objIStrm.readObject();
            System.out.println("object2: " + object2);
        }
        catch(Exception e) {
            System.out.println("Exception during deserialization: " + e);
        }
    }
}

public class SerializationDemo implements Serializable {
    String s;
    int i;
    double d;
    public SerializationDemo(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }
    public String toString() {
        return "s=" + s + "; i=" + i + "; d=" + d;
    }
}
