package CoolPack;
// An example of CyclicBarrier.
import java.util.concurrent.*;
public class BarDemo {
    public static void main(String... args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction() );
        System.out.println("Starting");
        new CoolThread(cb, "A");
        new CoolThread(cb, "B");
        new CoolThread(cb, "C");
        new CoolThread(cb, "X");
        new CoolThread(cb, "Y");
        new CoolThread(cb, "Z");
    }
}

// A thread of execution that uses a CyclicBarrier.
class CoolThread implements Runnable {
    CyclicBarrier cbar;
    String name;
    CoolThread(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
        new Thread(this).start();
    }
    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (BrokenBarrierException exc) {
            System.out.println("BrokenBarrierException caught");
        } catch (InterruptedException exc) {
            System.out.println("InterruptedException caught");
        }
    }
}
// An object of this class is called when the
// CyclicBarrier ends.
class BarAction implements Runnable {
    public void run() {
        System.out.println("Barrier Reached!");
    }
}