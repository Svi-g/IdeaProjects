package CoolPack;
import java.io.File;
// Using directories to find out
// what's inside by using list().
public class DirList {
    public static void main(String... args) {
        String dirname = "/java";
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("Directory of " + dirname);
            String[] s = f1.list();
            assert s != null;
            for (String value : s) {
                File f = new File(dirname + "/" + value);
                if (f.isDirectory()) {
                    System.out.println(value + " is a directory");
                } else {
                    System.out.println(value + " is a file");
                }
            }
        } else {
            System.out.println(dirname + " is not a directory");
        }
    }
}
