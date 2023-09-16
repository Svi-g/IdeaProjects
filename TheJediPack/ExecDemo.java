package CoolPack;

public class ExecDemo {
    @SuppressWarnings("deprecation")
    public static void main(String... args) {
        Runtime r = Runtime.getRuntime();
        Process p;
        try {
            p = r.exec("notes");
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        }
    }
}
