package CoolPack;

import java.awt.*;
import java.applet.*;

/*
<applet code="SimpleApplBanner" width=300 height=50>
</applet>
*/

public class SimpleApplBanner extends Applet implements Runnable {
    String msg = "A Simple Moving Banner.";
    Thread t = null;
    volatile boolean stopFlag;

    // Set colors and initialize thread.
    public void init() {
        setBackground(Color.cyan);
        setForeground(Color.red);
    }

    // Start the thread
    public void start() {
        if (t == null) {
            t = new Thread(this);
            stopFlag = false;
            t.start();
        }
    }

    // Entry point for the thread that runs the banner.
    public void run() {
        // Redisplay banner
        for (; ; ) {
            try {
                repaint();
                Thread.sleep(250);
                if (stopFlag)
                    break;
            } catch (InterruptedException e) {
            }
        }
    }

    // Pause the banner.
    public void stop() {
        stopFlag = true;
        t = null;
    }

    // Display the banner.
    public void paint(Graphics g) {
        char ch;
        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;
        g.drawString(msg, 50, 30);
    }
}
