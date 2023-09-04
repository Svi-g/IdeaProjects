package Umsonto;
/* Show all annotations for a class and a method. */
import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}
@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}
@What(description = "An annotation test class")
@MyAnno(str = "Meta2", val = 99)
public class Meta2 {
    @What(description = "An annotation test method")
    @MyAnno(str = "Testing", val = 100)
    public static void myMethy() {
        Meta2 ob = new Meta2();
        try {
            Annotation annos[] = ob.getClass().getAnnotations();
// Display all annotations for Meta2.
            System.out.println("All annotations for Meta2:");
            for(Annotation a : annos)
                System.out.println(a);
            System.out.println();
// Display all annotations for myMeth.
            Method m = ob.getClass( ).getMethod("myMethy");
            annos = m.getAnnotations();
            System.out.println("All annotations for myMethy:");
            for(Annotation a : annos)
                System.out.println(a);
        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }
    public static void main(String... args) {
        myMethy();
    }
}