package Umsonto;
/* This is a repeated annotation. */
import java.lang.annotation.*;
import java.lang.reflect.*;
/* MyAnno4 is now repeatable. */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface MyAnno4 {
    String str() default "Testing";
    int val() default 9000;
}
/* This is the container annotation. */
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos {
    MyAnno4[] value();
}
public class RepeatAnno {
    /* Repeat MyAnno4 on myMeth(). */
    @MyAnno4(str = "First annotation", val = -1)
    @MyAnno4(str = "Second annotation", val = 100)
    public static void myMeth(String str, int i) {
    RepeatAnno ob = new RepeatAnno();
try {
        Class<?> c = ob.getClass();
// Obtain the annotations for myMeth().
        Method m = c.getMethod("myMeth", String.class, int.class);
// Display the repeated MyAnno3 annotations.
        Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
        System.out.println(anno);
    } catch (NoSuchMethodException exc) {
        System.out.println("Method Not Found.");
    }
}
    public static void main(String... args) {
        myMeth("test", 10);
    }
}
