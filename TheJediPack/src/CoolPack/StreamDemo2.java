package CoolPack;
// Demonstrate the reduce() method.

import java.util.ArrayList;
import java.util.Optional;
public class StreamDemo2 {
    public static void main(String... args) {
        // Create a list of Integer values.
        ArrayList<Integer> myList = new ArrayList<>( );
        myList.add(7);// so izoqala yenze lena u "a"
        myList.add(18);// and then this will be "b"
                        //take the answer and use it as "a" in the next process
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);
// Two ways to obtain the integer product of the elements
// in myList by use of reduce().
        //Optional<Integer> productObj = myList.stream().reduce((a,b) -> a*b);
        Optional<Integer> productObj = myList.parallelStream().reduce((a,b) -> a*b);
        productObj.ifPresent(Integer -> System.out.println("Product as Optional: " + Integer));
        int product = myList.stream().reduce(1, (a,b) -> a*b);
        System.out.println("Product as int: " + product);
    }
}
