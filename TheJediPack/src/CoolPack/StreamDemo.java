package CoolPack;
/*
  This program:
  - Creates an ArrayList named myList.
  - myList holds a collection of integers (automatically boxed into Integer).
  - Obtains a stream using myList as the source.
  - Demonstrates various stream operations.
 */
import java.util.*;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String... args) {
        // Create a list of Integer values.
        ArrayList<Integer> myList = new ArrayList<>( );
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);
        System.out.println("Original list: " + myList);
// Obtain a Stream to the array list.
        Stream<Integer> myStream = myList.stream();
// Obtain the minimum and maximum value by use of min(),
// max(), isPresent(), and get().
        Optional<Integer> minVal = myStream.min(Integer::compare);
        minVal.ifPresent(integer -> System.out.println("Minimum value: " +
                integer));
// Must obtain a new stream because previous call to min()
// is a terminal operation that consumed the stream.
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        maxVal.ifPresent(integer -> System.out.println("Maximum value: " +
                integer));
// Sort the stream by use of sorted().
        Stream<Integer> sortedStream = myList.stream().sorted();
// Display the sorted stream by use of forEach().
        System.out.print("Sorted stream: ");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();
// Display only the odd values by use of filter().
        Stream<Integer> oddVals =
                myList.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.print("Odd values: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();
// Display only the odd values that are greater than 5. Notice that
// two filter operations are pipelined.
        oddVals = myList.stream().filter( (n) -> (n % 2) == 1)
                .filter((n) -> n > 5);
        System.out.print("Odd values greater than 5: ");
        oddVals.forEach((n) -> System.out.print(n + " ") );
        System.out.println();
    }
}
