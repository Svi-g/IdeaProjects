package CoolPack;
import java.util.*;
/*
Here's a short program that shows how to
use Formatter kuJava.
 */
public class FormatDemo {
    public static void main(String... args) {
    Formatter fmt = new Formatter();

    // Demonstrate the %n and %% format specifiers.
        fmt.format("Copying file%nTransfer is %d%% complete", 88);
        System.out.println(fmt);
    /*
    // formats floating-point values to
        // hexadecimal values
        fmt.format("%a", 512.0);
        System.out.println(fmt);
     */

    /*
    // formats values to Hex and Oct values
    fmt.format("Hex: %x, Octal: %o", 196, 196);
        System.out.println(fmt);
     */

    /*
    // formats scientific and floating point values.
    for(double i=1.23; i < 1.0e+6; i *= 100) {
            fmt.format("%f %e", i, i);
            System.out.println(fmt);
        }
        */
      /*
      // formats strings
        fmt.format("Formatting %s is easy %d %f", "with Java", 10, 98.6);
        System.out.println(fmt);
        fmt.close();
       */
        fmt.close();
    }
}
