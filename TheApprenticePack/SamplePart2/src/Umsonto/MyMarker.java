package Umsonto;
import java.lang.annotation.*;
import java.lang.reflect.*;
// A marker annotation.
@Retention(RetentionPolicy.RUNTIME)
public @interface MyMarker { }

class Marker {
    // Annotate a method using a marker.
// Notice that no ( ) is needed.
    @MyMarker
    public static void MarkMeth() {
        Marker ob = new Marker();
        try {
            Method m = ob.getClass().getMethod("MarkMeth");
// Determine if the annotation is present.
            if(m.isAnnotationPresent(MyMarker.class))
                System.out.println("MyMarker is present.");
        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }
    public static void main(String... args) {
        MarkMeth();
    }
}
