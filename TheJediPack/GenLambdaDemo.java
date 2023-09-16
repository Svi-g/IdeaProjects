package CoolPack;
/* This lambda demo shows how ilambda
interface can be generic, and how you
can use it w/ lambda expressions.
 */

// Nansti iGeneric functional interface.

interface SomeFunc<T> {
    T func(T t);
}

public class GenLambdaDemo {
    public static void main(String... args) {
// Use a String-based version of SomeFunc.
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            int i;
            for(i = str.length()-1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
        System.out.println("Batman reversed is " +
                reverse.func("Batman"));
        System.out.println("Superman reversed is " +
                reverse.func("Superman"));
// Now, use an Integer-based version of SomeFunc.
        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for(int i=1; i <= n; i++)
                result = i * result;
            return result;
        };
        System.out.println("The factoral of 3 is " + factorial.func(3));
        System.out.println("The factoral of 5 is " + factorial.func(5));
    }
}
