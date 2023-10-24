package CoolPack;
import java.util.*;
/*
The following is an example shows a custom
comparator. Notice that It implements
the compare( ) method for strings that
operate in reverse of normal.
 */

// A reverse comparator for strings.

/*
class MyComp implements Comparator<String> {
    public int compare(String aStr, String bStr) {
/*
        // Reverse the comparison.
        return bStr.compareTo(aStr);
 */
/*
        return aStr.compareTo(bStr);

                }
// No need to override equals or the default methods.
                }
 */
public class CompareDemo {
    public static void main(String... args) {
        //Comparator<String> mc = (aStr, bStr) -> aStr.compareTo(bStr);// Using Lambda
       // MyComp mc = new MyComp(); // Create a comparator
        //TreeSet<String> ts = new TreeSet<>(mc.reversed());
        // Passing a reversed comparator to TreeSet() using lambda.
        TreeSet<String> ts = new TreeSet<>(
                (aStr, bStr) -> bStr.compareTo(aStr));
        /*
        // Create a tree set.
        TreeSet<String> ts = new TreeSet<String>(new MyComp());
        */

// Add elements to the tree set.
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
// Display the elements.
        for(String element : ts)
            System.out.print(element + " ");
        System.out.println();
    }
}
