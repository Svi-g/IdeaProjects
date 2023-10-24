package CoolPack;
// Demonstrate reflection.
import java.lang.reflect.*;
public class ReflectionDemo1 {
    public static void main(String... args) {
        try {
        //Obtain a class instance ka java.awt.Dimension kuqala
            Class<?> c = Class.forName("java.awt.Dimension");
            System.out.println("Constructors:");
            Constructor<?>[] constructors = c.getConstructors(); // then get iconstructors
            for (Constructor<?> constructor : constructors) {
                System.out.println(" " + constructor);
            }
            System.out.println("Fields:");
            Field[] fields = c.getFields(); // wandule ngeFields
            for (Field field : fields) {
                System.out.println(" " + field);
            }
            System.out.println("Methods:");
            Method[] methods = c.getMethods(); //ugqibezele ngeMethods
            for (Method method : methods) {
                System.out.println(" " + method);
            }
        }
        catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }

}
