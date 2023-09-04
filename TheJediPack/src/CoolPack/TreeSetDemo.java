package CoolPack;

/*
TreeSet example.
 */

import java.util.*;
public class TreeSetDemo {
    public static void main(String... args) {
// Create a tree set.
        TreeSet<String> ts = new TreeSet<String>();
// Add elements to the tree set.
        ts.add("3");
        ts.add("2");
        ts.add("5");
        ts.add("1");
        ts.add("6");
        ts.add("7");
        System.out.println(ts);
        System.out.println(ts.subSet("3", "7"));
    }
}
