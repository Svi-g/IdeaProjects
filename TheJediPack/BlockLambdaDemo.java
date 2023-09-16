package CoolPack;
/* The following code represents a
a lambda block that reverses characters
*/

interface StringFunc {
    String func(String n);
}
public class BlockLambdaDemo {
    public static void main(String... args) {
        // This block lambda reverses the characters in a string.
        StringFunc2 reverse = (str) -> {
            String result = "";
            int i;
            for(i = str.length()-1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
        System.out.println("Lambda reversed is " +
                reverse.func("Lambda"));
        System.out.println("Expression reversed is " +
                reverse.func("Expression"));
    }
}
