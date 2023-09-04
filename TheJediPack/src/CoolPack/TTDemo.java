package CoolPack;
import java.util.*;
/*
This program demonstrates Time and TimerTask.
It shows a task that runs once every half
second after an initial delay of one second.
 */
class MyTimerTask extends TimerTask {
    public void run() {
        System.out.println("Timer task executed.");
    }
}

public class TTDemo {
    public static void main(String... args) {
        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();
/* Set an initial delay of 1 second,
then repeat every half second.
*/
        myTimer.schedule(myTask, 1000, 500);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exc) {}
        myTimer.cancel();
    }
}
