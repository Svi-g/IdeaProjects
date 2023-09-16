package CoolPack;
import java.util.*;
/*
The following program shows a simple use of ArrayList.
An array list is created for objects of type String,
and then several strings are added to it. (Recall that a quoted string
is translated into a String object.) The list is then
displayed. Some of the elements are
removed and the list is displayed again.
 */
public class ArrayListDemo {
    public static void main(String... args) {
// Create an array list.
        ArrayList<String> al = new ArrayList<String>();
        System.out.println("Initial size of al: " +
                al.size());
// Add elements to the array list.
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");
        System.out.println("Size of al after additions: " +
                al.size());
// Display the array list.
        System.out.println("Contents of al: " + al);
// Remove elements from the array list.
        al.remove("F");
        al.remove(2);
        System.out.println("Size of al after deletions: " +
                al.size());
        System.out.println("Contents of al: " + al);
    }
}
