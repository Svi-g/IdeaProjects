package CoolPack;
/*
The following example overrides clone()
so that it can be called from icode engaphandle of
its class. To do this, its access specifier
must be public, as shown apha:
 */

class TestClone2 implements Cloneable {
    int a;
    double b;

    // clone() is now overridden and is public.
    public Object clone() {
        try {
// call clone in Object.
            return super.clone();
        } catch(CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
            return this;
        }
    }
}

public class CloneDemo2 {
    public static void main(String... args) {
        TestClone2 x1 = new TestClone2();
        TestClone2 x2;
        x1.a = 10;
        x1.b = 20.98;
// here, clone() is called directly.
        x2 = (TestClone2) x1.clone();
        System.out.println("x1: " + x1.a + " " + x1.b);
        System.out.println("x2: " + x2.a + " " + x2.b);
    }
}
