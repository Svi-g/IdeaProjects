package CoolPack;
// A subclass can add its own type parameters.
class GenZ<T> {
    T ob; // d
    // eclare an object of type T
    // Pass the constructor a reference to
// an object of type T.
    GenZ(T o) {
        ob = o;
    }
    // Return ob.
    T getob() {
        return ob;
    }
}
// A subclass of Gen that defines a second
// type parameter, called V.
class Gen2<T, V> extends GenZ<T> {
    V ob2;
    Gen2(T o, V o2) {
        super(o);
        ob2 = o2;
    }
    V getob2() {
        return ob2;
    }
}
public class HierDemo {
    public static void main(String... args) {
// Create a Gen2 object for String and Integer.
        Gen2<String, Integer> x =
                new Gen2<String, Integer>("Value is: ", 99);
        System.out.print(x.getob());
        System.out.println(x.getob2());
    }
}
