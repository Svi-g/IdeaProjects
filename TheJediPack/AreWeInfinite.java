package CoolPack;
import java.lang.*;
public class AreWeInfinite {
    public static void main(String... args) {
        Double MnaNawe = new Double(1/0.);

        System.out.println("We are infinite" + ": " + MnaNawe.isInfinite());
    }
}
