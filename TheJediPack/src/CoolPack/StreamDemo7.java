package CoolPack;
// Use collect() to create a List and a Set from a stream.

import java.util.*;
import java.util.stream.*;

class GamaNumbaEmayile {
    String name;
    String phonenum;
    String email;
    GamaNumbaEmayile(String n, String p, String e) {
        name = n;
        phonenum = p;
        email = e;
    }
}

class GamaNumba {
    String name;
    String phonenum;
    GamaNumba(String n, String p) {
        name = n;
        phonenum = p;
    }
}


public class StreamDemo7 {
    public static void main(String... args) {
// A list of names, phone numbers, and e-mail addresses.
        ArrayList<GamaNumbaEmayile> myList = new ArrayList<>( );
        myList.add(new GamaNumbaEmayile("Larry", "555-5555",
                "Larry@HerbSchildt.com"));
        myList.add(new GamaNumbaEmayile("James", "555-4444",
                "James@HerbSchildt.com"));
        myList.add(new GamaNumbaEmayile("Mary", "555-3333",
                "Mary@HerbSchildt.com"));
// Map just the names and phone numbers to a new stream.
        Stream<GamaNumba> nameAndPhone = myList.stream().map(
                (a) -> new GamaNumba(a.name,a.phonenum)
        );
// Use collect to create a List of the names and phone numbers.
        //List<GamaNumba> npList = nameAndPhone.collect(Collectors.toList());
        List<GamaNumba> npList = nameAndPhone.toList();// ungayrnza nakanje
        System.out.println("Names and phone numbers in a List:");
        for(GamaNumba e : npList)
            System.out.println(e.name + ": " + e.phonenum);
// Obtain another mapping of the names and phone numbers.
        nameAndPhone = myList.stream().map(
                (a) -> new GamaNumba(a.name,a.phonenum)
        );
// Now, create a Set by use of collect().
        Set<GamaNumba> npSet = nameAndPhone.collect(Collectors.toSet());
        System.out.println("\nNames and phone numbers in a Set:");
        for(GamaNumba e : npSet)
            System.out.println(e.name + ": " + e.phonenum);
    }
}
