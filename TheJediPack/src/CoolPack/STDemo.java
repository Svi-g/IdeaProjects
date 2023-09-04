package CoolPack;
import java.util.StringTokenizer;

/*
This program shows a StringTokenizer. Mamela
ke, the first two Constructors do not return
the tokens. So that is why it returns like
that.
 */
public class STDemo {
    static String in = "title=Java: The Complete Reference;" +
            "author=Schildt;" +
            "publisher=McGraw-Hill;" +
            "copyright=2014";
    public static void main(String... args) {
        StringTokenizer st = new StringTokenizer(in, "=;");
        while(st.hasMoreTokens()) {
            String key = st.nextToken();
            String val = st.nextToken();
            System.out.println(key + "\t" + val);
        }
    }
}
