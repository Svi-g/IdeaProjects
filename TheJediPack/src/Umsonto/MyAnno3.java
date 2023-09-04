package Umsonto;
import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno3 {
    String str() default "Testing";
    int val() default 9000;
}

@SuppressWarnings("ALL")
class Meta3 {
    @MyAnno3()
    public static void methodMan() {
        Meta3 ob = new Meta3();

        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("methodMan");
            MyAnno3 anno = m.getAnnotation(MyAnno3.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }
    public static void main(String... args) {
        methodMan();
    }
}