package CoolPack;
// Use replaceAll().
import java.util.regex.*;

/*
 * Because the regular expression "Jon.*? " matches any string that begins with Jon followed
 * by zero or more characters, ending in a space, it can be used to match and replace both
 * Jon and Jonathan with the name Eric. Such a substitution is not easily accomplished
 * without pattern matching capabilities.
 */
public class RegExpr8 {
    public static void main(String... args) {
        String str = "Jon Jonathan Frank Ken Todd";

        Pattern pat = Pattern.compile("Jon.*? ");
        Matcher mat = pat.matcher(str);
        System.out.println("Original sequence: " + str);
        str = mat.replaceAll("Eric ");
        System.out.println("Modified sequence: " + str);
    }
}
