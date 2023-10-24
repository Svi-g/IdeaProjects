package CoolPack;
// An example of CountDownLatch.
import java.util.concurrent.CountDownLatch;
public class CDLDemo {
    public static void main(String... args) {
        CountDownLatch cdl = new CountDownLatch(5);
        System.out.println("Starting");
        new myThread(cdl);
        try {
            cdl.await();
        } catch (InterruptedException exc) {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Done");
    }
}

class myThread implements Runnable {
    CountDownLatch latch;
    myThread(CountDownLatch c) {
        latch = c;
        new Thread(this).start();
    }
    public void run() {
        for(int i = 0; i<5; i++) {
            System.out.println(i);
            latch.countDown(); // decrement count
        }
    }
}
