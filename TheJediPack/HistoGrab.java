package CoolPack;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class HistoGrab extends Frame {
    Dimension d;
    Image img;
    int iw, ih;
    int[] pixels;
    int w, h;
    int[] hist = new int[256];
    int max_hist = 0;

    public HistoGrab() {
        super("Histogram");
        setSize(400, 400);
        setLayout(new FlowLayout());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        loadImage();

        for (int i = 0; i < iw * ih; i++) {
            int p = pixels[i];
            int r = 0xff & (p >> 16);
            int g = 0xff & (p >> 8);
            int b = 0xff & (p);
            int y = (int) (.33 * r + .56 * g + .11 * b);
            hist[y]++;
        }

        for (int i = 0; i < 256; i++) {
            if (hist[i] > max_hist)
                max_hist = hist[i];
        }
    }

    private void loadImage() {
        try {
            img = Toolkit.getDefaultToolkit().getImage("Siviwe_1.png");
            MediaTracker t = new MediaTracker(this);
            t.addImage(img, 0);
            t.waitForID(0);
            iw = img.getWidth(null);
            ih = img.getHeight(null);
            pixels = new int[iw * ih];
            PixelGrabber pg = new PixelGrabber(img, 0, 0, iw, ih,
                    pixels, 0, iw);
            pg.grabPixels();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            return;
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
        int x = (w - 256) / 2;
        int lasty = h;
        for (int i = 0; i < 256; i++, x++) {
            int y = h - h * hist[i] / max_hist;
            g.setColor(new Color(i, i, i));
            g.fillRect(x, y, 1, h - y); // Corrected the height of the bar
            g.setColor(Color.red);
            g.drawLine(x - 1, lasty, x, y);
            lasty = y;
        }
    }

    public static void main(String... args) {
        HistoGrab appWindow = new HistoGrab();
        appWindow.setVisible(true);
    }
}
