package CoolPack;
import java.awt.*;
import java.awt.event.*;

public class TrackedImageLoad extends Frame implements Runnable {
    MediaTracker tracker;
    int tracked;
    int frame_rate = 5;
    int current_img = 0;
    Thread motor;
    static final int MAXIMAGES = 3; // Set the maximum number of images to 3
    Image[] img = new Image[MAXIMAGES];
    String[] name = new String[MAXIMAGES];
    volatile boolean stopFlag;

    public TrackedImageLoad() {
        super("Image Demo");
        setLayout(new FlowLayout());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Load images
        for (int i = 0; i < MAXIMAGES; i++) {
            name[i] = "Siviwe_" + (i + 1) + ".png"; // Image file names
            img[i] = Toolkit.getDefaultToolkit().getImage(name[i]);
        }

        tracker = new MediaTracker(this);

        for (int i = 0; i < MAXIMAGES; i++) {
            tracker.addImage(img[i], i);
        }
    }

    @Override
    public void paint(Graphics g) {
        String loaded = "";
        int donecount = 0;
        for (int i = 0; i < MAXIMAGES; i++) {
            if (tracker.checkID(i, true)) {
                donecount++;
                loaded += name[i] + " ";
            }
        }
        Dimension d = getSize();
        int w = d.width;
        int h = d.height;
        if (donecount == MAXIMAGES) {
            frame_rate = 1;
            Image i = img[current_img++];
            int iw = i.getWidth(null);
            int ih = i.getHeight(null);
            g.drawImage(i, (w - iw) / 2, (h - ih) / 2, null);
            if (current_img >= MAXIMAGES)
                current_img = 0;
        } else {
            int x = w * donecount / MAXIMAGES;
            g.setColor(Color.black);
            g.fillRect(0, h / 3, x, 16);
            g.setColor(Color.white);
            g.fillRect(x, h / 3, w - x, 16);
            g.setColor(Color.black);
            g.drawString(loaded, 10, h / 2);
        }
    }

    public void start() {
        motor = new Thread(this);
        stopFlag = false;
        motor.start();
    }

    public void stop() {
        stopFlag = true;
    }

    public void run() {
        motor.setPriority(Thread.MIN_PRIORITY);
        while (true) {
            repaint();
            try {
                Thread.sleep(1000 / frame_rate);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }
            if (stopFlag)
                return;
        }
    }

    public static void main(String... args) {
        TrackedImageLoad appWindow = new TrackedImageLoad();
        appWindow.setSize(400, 400); // Set the window size
        appWindow.setVisible(true);
        appWindow.start();
    }
}
