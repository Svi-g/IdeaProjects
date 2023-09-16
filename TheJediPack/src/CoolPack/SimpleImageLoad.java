package CoolPack;

import java.awt.*;
import java.awt.event.*;

public class SimpleImageLoad extends Frame {
    Image img;

    public SimpleImageLoad() {
        super("Image Demo");
        setLayout(new FlowLayout());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Load image
        img = Toolkit.getDefaultToolkit().getImage("Siviwe_1.png");

        // Wait for the image to load before setting frame size
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(img, 0);
        try {
            mt.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Set Frame properties
        setSize(img.getWidth(this), img.getHeight(this));
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, this);
    }

    public static void main(String... args) {
        SimpleImageLoad appWindow = new SimpleImageLoad();
        appWindow.setSize(400, 400);
        appWindow.setVisible(true);
    }
}
